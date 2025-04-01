import {appSchema, tableSchema} from "@nozbe/watermelondb";

export const TrainerSchema = appSchema({
    version: 1,
    tables: [
        tableSchema({
            name: 'pokemons',
            columns: [
                {name: 'pokemon_id', type: 'string', isIndexed: true},
                {name: 'name', type: 'string'},
                {name: 'official_artwork', type: 'string'},
                {name: 'stats', type: 'string'},
                {name: 'types', type: 'string'},
                {name: 'height_cm', type: 'number'},
                {name: 'weight_kg', type: 'number'},
                {name: 'species', type: 'string'},
                {name: 'abilities', type: 'string'},
                {name: 'is_favorite', type: 'boolean', isOptional: true},
            ],
        })
    ],
});

/*
    @PrimaryKey val id: String,
    val name: String,
    val officialArtwork: String,
    val stats: Map<PokemonStat, Int>,
    val types: List<PokemonType>,
    val heightCm: Float,
    val weightKg: Float,
    val species: String,
    val abilities: List<String>,
 */