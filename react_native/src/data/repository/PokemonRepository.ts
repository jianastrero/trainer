import usePokeApiRemote from "../remote/PokeApiRemote.ts";
import usePokemonDataStore from "../datastore/PokemonDataStore.ts";
import {useState} from "react";
import Pokemon from "../../domain/entity/Pokemon.ts";
import PokemonItemResponse from "../../domain/model/pokeapi/response/PokemonItemResponse.ts";
import {PokemonResponse} from "../../domain/model/pokeapi/response/PokemonResponse.ts";
import PokemonSpeciesResponse from "../../domain/model/pokeapi/response/PokemonSpeciesResponse.ts";
import {field, text} from "@nozbe/watermelondb/decorators";

interface PokemonRepository {
    pokemonList: Pokemon[];
    updatePokemonList: () => void;
}

export default function usePokemonRepository(): PokemonRepository {
    const {
        getAllPokemon: getAllRemote,
        getPokemonById: getRemote,
        getPokemonSpeciesById: getSpeciesRemote
    } = usePokeApiRemote();
    const {
        getAllPokemon: getAllLocal,
        getPokemonById: getLocal,
        getFavoritePokemons: getFavoritesLocal,
        createPokemon: createLocal
    } = usePokemonDataStore();

    const [pokemonList, setPokemonList] = useState<Pokemon[]>([]);

    const removeLocals = (list: PokemonItemResponse[], other: Pokemon[]) => {
        const namesInOther = new Set(other.map(pokemon => pokemon.name));
        return list.filter(pokemon => !namesInOther.has(pokemon.name));
    };

    const updateAllPokemonAsync = async () => {
        console.log("Fetching all Pokemon...");
        let remoteList: PokemonItemResponse[] = [];

        try {
            const response: {name: string, url: string}[] = await getAllRemote();
            remoteList = response.map(item => {
                return new PokemonItemResponse(item.name, item.url);
            });
        } catch (e) {
            console.error("Error fetching remote Pokemon list: ", e);
        }

        const response: {
            pokemonId: string,
            name: string,
            officialArtwork: string,
            stats: string,
            types: string,
            heightCm: number,
            weightKg: number,
            species: string,
            abilities: string,
            isFavorite: boolean,
        }[] = await getAllLocal();
        const localList: Pokemon[] = response.map(item => {
            return Pokemon.create(
                item.pokemonId,
                item.name,
                item.officialArtwork,
                item.stats,
                item.types,
                item.heightCm,
                item.weightKg,
                item.species,
                item.abilities,
                item.isFavorite
            );
        });

        if (localList.length == remoteList.length) {
            // If the local list is the same size as the remote list, we can assume they are the same
            console.log("Local and remote lists are the same size, no need to fetch remote data");
            return;
        }

        setPokemonList(localList);
        remoteList = removeLocals(remoteList, localList);

        for (const item of remoteList) {
            let pokemonResponse: PokemonResponse | null = null;
            let pokemonSpeciesResponse: PokemonSpeciesResponse | null = null;
            let newPokemon: Pokemon | null = null;
            try {
                pokemonResponse = await getRemote(item.getId());
            } catch (e) {
                console.error("Error fetching remote Pokemon: ", item.name);
            }
            try {
                pokemonSpeciesResponse = await getSpeciesRemote(item.getId());
            } catch (e) {
                console.error("Error fetching remote Pokemon species: ", item.name);
            }
            try {
                if (pokemonResponse) {
                    newPokemon = Pokemon.fromPokeApiResponse(pokemonResponse, pokemonSpeciesResponse);
                }
            } catch (e) {
                console.error("Error creating Pokemon from remote data: ", item.name);
            }
            if (newPokemon) {
                localList.push(newPokemon);
                setPokemonList([...localList]);

                // Add the new Pokemon to the local database without blocking the fetching of the next Pokemon
                createLocal(newPokemon)
            }
        }
    };

    const updatePokemonList = () => {
        updateAllPokemonAsync();
    };

    return {
        pokemonList: pokemonList,
        updatePokemonList: updatePokemonList
    };
}