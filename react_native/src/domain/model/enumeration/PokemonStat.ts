export class PokemonStat {

    public label: string;

    protected constructor(label: string) {
        this.label = label;
    }

    public static HP: PokemonStat = new PokemonStat("HP");
    public static Attack: PokemonStat = new PokemonStat("Attack");
    public static Defense: PokemonStat = new PokemonStat("Defense");
    public static SpecialAttack: PokemonStat = new PokemonStat("Special Attack");
    public static SpecialDefense: PokemonStat = new PokemonStat("Special Defense");
    public static Speed: PokemonStat = new PokemonStat("Speed");

    public static all(): PokemonStat[] {
        return [
            PokemonStat.HP,
            PokemonStat.Attack,
            PokemonStat.Defense,
            PokemonStat.SpecialAttack,
            PokemonStat.SpecialDefense,
            PokemonStat.Speed,
        ];
    }

    public static getFromString(stat: string): PokemonStat | undefined {
        switch (stat.toLowerCase()) {
            case 'hp':
                return PokemonStat.HP;
            case 'attack':
                return PokemonStat.Attack;
            case 'defense':
                return PokemonStat.Defense;
            case 'special-attack':
            case 'specialattack':
                return PokemonStat.SpecialAttack;
            case 'special-defense':
            case 'specialdefense':
                return PokemonStat.SpecialDefense;
            case 'speed':
                return PokemonStat.Speed;
            default:
                return undefined;
        }
    }
}

export class PokemonStatItem {
    public stat: PokemonStat;
    public baseStat: number;

    constructor(stat: PokemonStat, baseStat: number) {
        this.stat = stat;
        this.baseStat = baseStat;
    }
}
