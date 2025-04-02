import {StatusBar, View, StyleSheet, FlatList,} from "react-native";
import useTrainerTheme from "../../theme/TrainerTheme.ts";
import {AppBarTemplate} from "../../template/AppBarTemplate.tsx";
import {PokemonListItem} from "../../molecule/PokemonListItem.tsx";
import {useEffect, useState} from "react";
import usePokemonRepository from "../../../data/repository/PokemonRepository.ts";

export default function HomePage() {
    const theme = useTrainerTheme();
    const viewPokemon = () => {
        console.log("View PokemonItemResponse");
    };

    const {pokemonList, updatePokemonList} = usePokemonRepository();

    useEffect(() => {
        console.log("Calling updatePokemonList");
        updatePokemonList();
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
                                imageUrl={item.officialArtwork}
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

