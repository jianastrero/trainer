import {trainerDatabase} from "../database/Database.ts";
import Pokemon from "../../domain/entity/Pokemon.ts";
import {Q} from "@nozbe/watermelondb";

interface PokemonDataStore {
    getAllPokemons: () => Promise<Pokemon[]>;
    getFavoritePokemons: () => Promise<Pokemon[]>;
    getPokemonById: (pokemonId: string) => Promise<Pokemon | null>;
    createPokemon: (pokemon: Pokemon) => Promise<void>;
}

function usePokemonDataStore(): PokemonDataStore {
    const pokemonCollection = trainerDatabase.get<Pokemon>("pokemons");
    const getPokemonList = async (): Promise<Pokemon[]> => {
        return await pokemonCollection.query().fetch();
    };
    const getFavoritePokemons = async (): Promise<Pokemon[]> => {
        return await pokemonCollection.query(Q.where("is_favorite", true)).fetch();
    };
    const getPokemonById = async (pokemonId: string): Promise<Pokemon | null> => {
        const list = await pokemonCollection.query(
            Q.where("pokemon_id", pokemonId)
        ).fetch();

        if (list.length === 0) {
            return null;
        }

        return list[0];
    };
    const createPokemon = async (pokemon: Pokemon): Promise<void> => {
        await pokemonCollection.create((newPokemon) => {
            newPokemon.pokemonId = pokemon.pokemonId;
            newPokemon.name = pokemon.name;
            newPokemon.officialArtwork = pokemon.officialArtwork;
            newPokemon.stats = JSON.stringify(pokemon.getStats());
            newPokemon.types = JSON.stringify(pokemon.getTypes());
            newPokemon.heightCm = pokemon.heightCm;
            newPokemon.weightKg = pokemon.weightKg;
            newPokemon.species = pokemon.species;
            newPokemon.abilities = JSON.stringify(pokemon.getAbilities());
        });
    };

    return {
        getAllPokemons: getPokemonList,
        getFavoritePokemons: getFavoritePokemons,
        getPokemonById: getPokemonById,
        createPokemon: createPokemon
    } as PokemonDataStore;
}