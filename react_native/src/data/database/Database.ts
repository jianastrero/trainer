import SQLiteAdapter from "@nozbe/watermelondb/adapters/sqlite";

import {TrainerSchema} from "./Schema.ts";
import {TrainerMigrations} from "./Migrations.ts";
import {Collection, Database} from "@nozbe/watermelondb";
import Pokemon from "../../domain/entity/Pokemon.ts";

const trainerAdapter = new SQLiteAdapter({
    schema: TrainerSchema,
    migrations: TrainerMigrations,
    jsi: true,
    onSetUpError: error => {
        console.error("Error setting up database", error);
    }
});

const trainerDatabase = new Database({
    adapter: trainerAdapter,
    modelClasses: [Pokemon],
});

export function getTrainerDatabase(): Database {
    return trainerDatabase;
}

let pokemonCollection: Collection<Pokemon> | null = null;
export function getPokemonCollection(): Collection<Pokemon> {
    if (pokemonCollection) {
        return pokemonCollection;
    }
    pokemonCollection = trainerDatabase.get<Pokemon>("pokemons");
    return pokemonCollection;
}
