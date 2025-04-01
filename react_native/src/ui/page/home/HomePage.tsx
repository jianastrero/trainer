import {StatusBar, View, StyleSheet, Text, Animated, FlatList,} from "react-native";
import useTrainerTheme from "../../theme/TrainerTheme.ts";
import {AppBarTemplate} from "../../template/AppBarTemplate.tsx";
import {PokemonListItem} from "../../molecule/PokemonListItem.tsx";
import usePokeApiRemote from "../../../data/remote/PokeApiRemote.ts";
import {useEffect, useState} from "react";
import PokemonItemResponse, {
    getPokemonItemImageUrl
} from "../../../domain/model/pokeapi/response/PokemonItemResponse.ts";

export default function HomePage() {
    const theme = useTrainerTheme();
    const viewPokemon = () => {
        console.log("View PokemonItemResponse");
    };

    const {getAllPokemon} = usePokeApiRemote();

    const [pokemonList, setPokemonList] = useState<PokemonItemResponse[]>([]);
    useEffect(() => {
        getAllPokemon().then((pokemonList) => {
            setPokemonList(pokemonList);
        }).catch((error) => {
            console.error("Error fetching pokemon list: ", error);
        });
    }, []);

    return (
        <View style={[styles.container, { backgroundColor: theme.colors.background }]}>
            <StatusBar barStyle={theme.isDarkMode ? 'light-content' : 'dark-content'}/>
            <AppBarTemplate style={styles.pageContainer}>
                <FlatList
                    data={pokemonList}
                    renderItem={
                        ({ item }) => (
                            <PokemonListItem
                                name={item.name}
                                imageUrl={getPokemonItemImageUrl(item)}
                                onPress={viewPokemon}
                            />
                        )
                    }
                style={styles.listContainer}/>
            </AppBarTemplate>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        display: 'flex',
        flex: 1,
        flexDirection: 'column',
        width: '100%',
        height: '100%',
        paddingTop: StatusBar.currentHeight,
    },
    pageContainer: {
        width: '100%',
        height: '100%',
    },
    listContainer: {
        display: 'flex',
        flexDirection: 'column',
        width: '100%',
    },
});

