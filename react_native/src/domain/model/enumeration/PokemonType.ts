import Pokemon from "../../entity/Pokemon.ts";

export class PokemonType {
    public label: string;
    public color: string;

    protected constructor(label: string, color: string) {
        this.label = label;
        this.color = color;
    }

    public static Test = new PokemonType('Test', '#000000');

    public static Normal: PokemonType = new PokemonType('Normal', '#A8A77A');
    public static Fighting: PokemonType = new PokemonType('Fighting', '#C22E28');
    public static Flying: PokemonType = new PokemonType('Flying', '#A98FF3');
    public static Poison: PokemonType = new PokemonType('Poison', '#A33EA1');
    public static Ground: PokemonType = new PokemonType('Ground', '#E2BF65');
    public static Rock: PokemonType = new PokemonType('Rock', '#B6A136');
    public static Bug: PokemonType = new PokemonType('Bug', '#A6B91A');
    public static Ghost: PokemonType = new PokemonType('Ghost', '#735797');
    public static Steel: PokemonType = new PokemonType('Steel', '#B7B7CE');
    public static Fire: PokemonType = new PokemonType('Fire', '#EE8130');
    public static Water: PokemonType = new PokemonType('Water', '#6390F0');
    public static Grass: PokemonType = new PokemonType('Grass', '#7AC74C');
    public static Electric: PokemonType = new PokemonType('Electric', '#F7D02C');
    public static Psychic: PokemonType = new PokemonType('Psychic', '#F95587');
    public static Ice: PokemonType = new PokemonType('Ice', '#96D9D6');
    public static Dragon: PokemonType = new PokemonType('Dragon', '#6F35FC');
    public static Dark: PokemonType = new PokemonType('Dark', '#705746');
    public static Fairy: PokemonType = new PokemonType('Fairy', '#D685AD');
    public static Stellar: PokemonType = new PokemonType('Stellar', '#46647E');
    public static Unknown: PokemonType = new PokemonType('Unknown', '#827E7A');
    public static Shadow: PokemonType = new PokemonType('Shadow', '#2B4463');

    public static all(): PokemonType[] {
        return [
            PokemonType.Normal,
            PokemonType.Fighting,
            PokemonType.Flying,
            PokemonType.Poison,
            PokemonType.Ground,
            PokemonType.Rock,
            PokemonType.Bug,
            PokemonType.Ghost,
            PokemonType.Steel,
            PokemonType.Fire,
            PokemonType.Water,
            PokemonType.Grass,
            PokemonType.Electric,
            PokemonType.Psychic,
            PokemonType.Ice,
            PokemonType.Dragon,
            PokemonType.Dark,
            PokemonType.Fairy,
            PokemonType.Stellar,
            PokemonType.Unknown,
            PokemonType.Shadow
        ];
    }

    public static getFromString(type: string): PokemonType {
        const typeLower = type.toLowerCase();
        return PokemonType.all().find((t) => t.label.toLowerCase() === typeLower) || this.Unknown;
    }
}
