import {Model} from "@nozbe/watermelondb";
import {field, text, writer} from "@nozbe/watermelondb/decorators";
import {allPokemonStats, PokemonStat, getPokemonStatFromString} from "../model/enumeration/PokemonStat.ts";
import {getPokemonTypeFromString, PokemonType} from "../model/enumeration/PokemonType.ts";

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

    @writer async setFavorite(isFavorite: boolean) {
        await this.update((pokemon) => {
            pokemon.isFavorite = isFavorite;
        });
    }

    getStats(): Map<PokemonStat, number> {
        const jsonObject = JSON.parse(this.stats);
        if (!jsonObject) {
            return new Map<PokemonStat, number>();
        }

        const statsMap = new Map<PokemonStat, number>();
        Object.entries(jsonObject).forEach(([key, value]) => {
            const stat = getPokemonStatFromString(key);

            if (stat && typeof value === "number") {
                statsMap.set(stat, value);
            }
        });

        return statsMap;
    }

    getAbilities(): string[] {
        const jsonList = JSON.parse(this.abilities);
        if (!jsonList) {
            return [];
        }

        return jsonList;
    }

    getTypes(): PokemonType[] {
        const jsonList = JSON.parse(this.types);
        if (!jsonList) {
            return [];
        }

        const typesList: PokemonType[] = [];
        jsonList.forEach((type: string) => {
            const pokemonType = getPokemonTypeFromString(type);
            if (pokemonType) {
                typesList.push(pokemonType);
            }
        });

        return typesList;
    }
}
