export default interface PokemonItemResponse {
    name: string
    url: string
}

export function getPokemonItemImageUrl(item: PokemonItemResponse): string {
    const splits = item.url.split('/');
    return `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonItemId(item)}.png`;
}

function getPokemonItemId(item: PokemonItemResponse): string {
    const splits = item.url.split('/');
    return splits[splits.length - 2];
}
