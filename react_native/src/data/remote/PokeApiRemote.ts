import axios from "axios";
import {PokemonResponse} from "../../domain/model/pokeapi/response/PokemonResponse.ts";
import PaginatedPokeApiResponse from "../../domain/model/pokeapi/response/PaginatedPokeApiResponse.ts";
import PokemonItemResponse from "../../domain/model/pokeapi/response/PokemonItemResponse.ts";
import PokemonSpeciesResponse from "../../domain/model/pokeapi/response/PokemonSpeciesResponse.ts";

interface PokeApiRemote {
    getAllPokemon: () => Promise<PokemonItemResponse[]>;
    getPokemonById: (pokemonId: string) => Promise<PokemonResponse>;
    getPokemonSpeciesById: (pokemonId: string) => Promise<PokemonSpeciesResponse>;
}

export default function usePokeApiRemote() {
    const getAllPokemon = async (): Promise<PokemonItemResponse[]> => {
        const response = await axios.get<PaginatedPokeApiResponse<PokemonItemResponse>>(`https://pokeapi.co/api/v2/pokemon?offset=0&limit=10000`);
        return response.data.results;
    };
    const getPokemonById = async (pokemonId: string): Promise<PokemonResponse> => {
        const response = await axios.get<PokemonResponse>(`https://pokeapi.co/api/v2/pokemon/${pokemonId}`);
        return response.data;
    }
    const getPokemonSpeciesById = async (pokemonId: string): Promise<PokemonSpeciesResponse> => {
        const response = await axios.get<PokemonSpeciesResponse>(`https://pokeapi.co/api/v2/pokemon-species/${pokemonId}`);
        return response.data;
    }

    return {
        getAllPokemon: getAllPokemon,
        getPokemonById: getPokemonById,
        getPokemonSpeciesById: getPokemonSpeciesById
    } as PokeApiRemote;
};