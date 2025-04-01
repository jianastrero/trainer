export enum PokemonStat {
    HP = 'HP',
    Attack = 'Attack',
    Defense = 'Defense',
    SpecialAttack = 'Special Attack',
    SpecialDefense = 'Special Defense',
    Speed = 'Speed',
}

export function allPokemonStats(): PokemonStat[] {
    return [
        PokemonStat.HP,
        PokemonStat.Attack,
        PokemonStat.Defense,
        PokemonStat.SpecialAttack,
        PokemonStat.SpecialDefense,
        PokemonStat.Speed,
    ];
}

export function getPokemonStatFromString(stat: string): PokemonStat | undefined {
    switch (stat) {
        case 'hp':
        case 'HP':
            return PokemonStat.HP;
        case 'attack':
        case 'Attack':
            return PokemonStat.Attack;
        case 'defense':
        case 'Defense':
            return PokemonStat.Defense;
        case 'special-attack':
        case 'SpecialAttack':
            return PokemonStat.SpecialAttack;
        case 'special-defense':
        case 'SpecialDefense':
            return PokemonStat.SpecialDefense;
        case 'speed':
        case 'Speed':
            return PokemonStat.Speed;
        default:
            return undefined;
    }
}
