export default class PokemonItemResponse {
    public name: string
    public url: string

    constructor(name: string, url: string) {
        this.name = name;
        this.url = url;
    }

    getId(): string {
        const splits = this.url.split('/');
        return splits[splits.length - 2];
    }

    getImageUrl(): string {
        return `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${this.getId()}.png`;
    }
}
