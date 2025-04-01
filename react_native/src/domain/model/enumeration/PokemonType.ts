
export enum PokemonType {
    Normal = 'Normal',
    Fighting = 'Fighting',
    Flying = 'Flying',
    Poison = 'Poison',
    Ground = 'Ground',
    Rock = 'Rock',
    Bug = 'Bug',
    Ghost = 'Ghost',
    Steel = 'Steel',
    Fire = 'Fire',
    Water = 'Water',
    Grass = 'Grass',
    Electric = 'Electric',
    Psychic = 'Psychic',
    Ice = 'Ice',
    Dragon = 'Dragon',
    Dark = 'Dark',
    Fairy = 'Fairy',
    Stellar = 'Stellar',
    Unknown = 'Unknown',
    Shadow = 'Shadow',
}

export function getTypeColor(type: PokemonType) {
    switch (type) {
        case PokemonType.Normal:
            return '#A8A77A';
        case PokemonType.Fighting:
            return '#C22E28';
        case PokemonType.Flying:
            return '#A98FF3';
        case PokemonType.Poison:
            return '#A33EA1';
        case PokemonType.Ground:
            return '#E2BF65';
        case PokemonType.Rock:
            return '#B6A136';
        case PokemonType.Bug:
            return '#A6B91A';
        case PokemonType.Ghost:
            return '#735797';
        case PokemonType.Steel:
            return '#B7B7CE';
        case PokemonType.Fire:
            return '#EE8130';
        case PokemonType.Water:
            return '#6390F0';
        case PokemonType.Grass:
            return '#7AC74C';
        case PokemonType.Electric:
            return '#F7D02C';
        case PokemonType.Psychic:
            return '#F95587';
        case PokemonType.Ice:
            return '#96D9D6';
        case PokemonType.Dragon:
            return '#6F35FC';
        case PokemonType.Dark:
            return '#705746';
        case PokemonType.Fairy:
            return '#D685AD';
        default:
            return '#827E7A'; // Unknown type
    }
}

export function getPokemonTypeFromString(type: string): PokemonType | null {
    const typeUpper = type.charAt(0).toUpperCase() + type.slice(1).toLowerCase();
    if (typeUpper in PokemonType) {
        return PokemonType[typeUpper as keyof typeof PokemonType];
    }
    return null;
}
