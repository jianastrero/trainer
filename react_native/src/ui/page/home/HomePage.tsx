import {StatusBar, View, StyleSheet, Text,} from "react-native";
import useTrainerTheme from "../../theme/TrainerTheme.ts";
import {AppBarTemplate} from "../../template/AppBarTemplate.tsx";
import {PokemonListItem} from "../../molecule/PokemonListItem.tsx";

export default function HomePage() {
    const theme = useTrainerTheme();
    const viewPokemon = () => {
        console.log("View Pokemon");
    };

    return (
        <View style={[styles.container, { backgroundColor: theme.colors.background }]}>
            <StatusBar barStyle={theme.isDarkMode ? 'light-content' : 'dark-content'}/>
            <AppBarTemplate style={styles.pageContainer}>
                <PokemonListItem name={'Bulbasaur'}
                                 imageUrl={'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png'}
                                 onPress={viewPokemon} />
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
    }
});

