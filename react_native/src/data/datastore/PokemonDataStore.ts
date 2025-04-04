import {getPokemonCollection, getTrainerDatabase} from "../database/Database.ts";
import Pokemon from "../../domain/entity/Pokemon.ts";
import {Q} from "@nozbe/watermelondb";

interface PokemonDataStore {
    getAllPokemon: () => Promise<Pokemon[]>;
    getFavoritePokemons: () => Promise<Pokemon[]>;
    getPokemonById: (pokemonId: string) => Promise<Pokemon | null>;
    createPokemon: (pokemon: Pokemon) => Promise<void>;
}

export default function usePokemonDataStore(): PokemonDataStore {

    const getPokemonList = async (): Promise<Pokemon[]> => {
        return await getPokemonCollection().query().fetch();
    };

    const getFavoritePokemons = async (): Promise<Pokemon[]> => {
        return await getPokemonCollection().query(Q.where("is_favorite", true)).fetch();
    };

    const getPokemonById = async (pokemonId: string): Promise<Pokemon | null> => {
        const list = await getPokemonCollection().query(
            Q.where("pokemon_id", pokemonId)
        ).fetch();

        if (list.length === 0) {
            return null;
        }

        return list[0];
    };

    const createPokemon = async (pokemon: Pokemon): Promise<void> => {
        await getTrainerDatabase().write(async () => {
            await getPokemonCollection().create((newPokemon) => {
                newPokemon.pokemonId = pokemon.pokemonId;
                newPokemon.name = pokemon.name;
                newPokemon.officialArtwork = pokemon.officialArtwork;
                newPokemon.stats = pokemon.stats;
                newPokemon.types = pokemon.types;
                newPokemon.heightCm = pokemon.heightCm;
                newPokemon.weightKg = pokemon.weightKg;
                newPokemon.species = pokemon.species;
                newPokemon.abilities = pokemon.abilities;
            });
        });
    };

    return {
        getAllPokemon: getPokemonList,
        getFavoritePokemons: getFavoritePokemons,
        getPokemonById: getPokemonById,
        createPokemon: createPokemon
    } as PokemonDataStore;
}