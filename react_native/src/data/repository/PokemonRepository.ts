import usePokeApiRemote from "../remote/PokeApiRemote.ts";
import usePokemonDataStore from "../datastore/PokemonDataStore.ts";
import {useState} from "react";
import Pokemon from "../../domain/entity/Pokemon.ts";
import PokemonItemResponse from "../../domain/model/pokeapi/response/PokemonItemResponse.ts";

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
            remoteList = await getAllRemote();
            console.log("Remote list: ", remoteList);
        } catch (e) {
            console.error("Error fetching remote Pokemon list: ", e);
        }

        const localList = await getAllLocal();

        if (localList.length == remoteList.length) {
            // If the local list is the same size as the remote list, we can assume they are the same
            console.log("Local and remote lists are the same size, no need to fetch remote data");
            return;
        }

        setPokemonList(localList);
        console.log("Local list: ", localList);

        remoteList = removeLocals(remoteList, localList);
        console.log("Filtered remote list: ", remoteList);

        for (const item of remoteList) {
            try {
                const pokemon = await getRemote(item.name);
                const species = await getSpeciesRemote(item.name);
                const newPokemon = Pokemon.fromPokeApiResponse(pokemon, species);
                pokemonList.push(newPokemon);

                // Add the new Pokemon to the local database without blocking the fetching of the next Pokemon
                createLocal(newPokemon)
                    .then(() => {
                        console.log(`Pokemon added to database: ${newPokemon.name}`)
                    })
                    .catch((error) => {
                        console.error(`Error adding Pokemon to database: ${error}`)
                    });
            } catch (e) {
                console.error("Error fetching remote Pokemon: ", e);
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