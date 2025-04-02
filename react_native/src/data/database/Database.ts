import SQLiteAdapter from "@nozbe/watermelondb/adapters/sqlite";

import {TrainerSchema} from "./Schema.ts";
import {TrainerMigrations} from "./Migrations.ts";
import {Database} from "@nozbe/watermelondb";
import Pokemon from "../../domain/entity/Pokemon.ts";

const trainerAdapter = new SQLiteAdapter({
    schema: TrainerSchema,
    migrations: TrainerMigrations,
    jsi: true,
    onSetUpError: error => {
        console.error("Error setting up database", error);
    }
});

export const trainerDatabase = new Database({
    adapter: trainerAdapter,
    modelClasses: [Pokemon],
});
