import {Model} from "@nozbe/watermelondb";
import {field, text, writer} from "@nozbe/watermelondb/decorators";
import {PokemonResponse} from "../model/pokeapi/response/PokemonResponse.ts";
import PokemonSpeciesResponse from "../model/pokeapi/response/PokemonSpeciesResponse.ts";
import {PokemonStat, PokemonStatItem} from "../model/enumeration/PokemonStat.ts";
import {PokemonType} from "../model/enumeration/PokemonType.ts";

export default class Pokemon extends Model {
    static table = 'pokemons';

    @text("pokemon_id") pokemonId!: string;
    @text("name") name!: string;
    @text("official_artwork") officialArtwork!: string;
    @text("stats") stats!: string;
    @text("types") types!: string;
    @field("height_cm") heightCm!: number;
    @field("weight_kg") weightKg!: number;
    @text("species") species!: string;
    @text("abilities") abilities!: string;
    @field("is_favorite") isFavorite!: boolean;

    static create(
        pokemonId: string,
        name: string,
        officialArtwork: string,
        stats: string,
        types: string,
        heightCm: number,
        weightKg: number,
        species: string,
        abilities: string,
        isFavorite: boolean
    ) {
        return {
            pokemonId,
            name,
            officialArtwork,
            stats,
            types,
            heightCm,
            weightKg,
            species,
            abilities,
            isFavorite
        } as Pokemon;
    }

    @writer async setFavorite(isFavorite: boolean) {
        await this.update((pokemon) => {
            pokemon.isFavorite = isFavorite;
        });
    }

    getStatList(): PokemonStatItem[] {
        const jsonObject = JSON.parse(this.stats);
        if (!jsonObject) {
            return [];
        }
        console.log("getStatList -> jsonObject", jsonObject);

        const list: PokemonStatItem[] = [];
        Object.entries(jsonObject).forEach(([key, value]) => {
            const stat = PokemonStat.getFromString(key);

            if (stat && typeof value === "number") {
                list.push({
                    stat: stat,
                    baseStat: value
                });
            }
        });

        return list;
    }

    getAbilityList(): string[] {
        const jsonList = JSON.parse(this.abilities);
        if (!jsonList) {
            return [];
        }

        return jsonList;
    }

    getTypeList(): PokemonType[] {
        const jsonList = JSON.parse(this.types);
        if (!jsonList) {
            return [];
        }

        const typesList: PokemonType[] = [];
        jsonList.forEach((type: string) => {
            const pokemonType = PokemonType.getFromString(type);
            if (pokemonType) {
                typesList.push(pokemonType);
            }
        });

        return typesList;
    }

    static fromPokeApiResponse(pokemon: PokemonResponse, species: PokemonSpeciesResponse | null): Pokemon {
        const stats: PokemonStatItem[] = [];
        pokemon.stats.forEach((stat) => {
            const statName = PokemonStat.getFromString(stat.stat.name);
            if (statName) {
                stats.push({
                    stat: statName,
                    baseStat: stat.base_stat
                });
            }
        });

        const types = pokemon.types.map((type) => type.type.name);

        return {
            pokemonId: pokemon.id,
            name: pokemon.name,
            officialArtwork: pokemon.sprites.other["official-artwork"].front_default,
            stats: JSON.stringify(stats),
            types: JSON.stringify(types),
            heightCm: pokemon.height,
            weightKg: pokemon.weight,
            species: species?.genera?.find((genus) => genus.language.name === "en")?.genus || "",
            abilities: JSON.stringify(pokemon.abilities.map((ability) => ability.ability.name)),
            isFavorite: false
        } as Pokemon;
    }
}
