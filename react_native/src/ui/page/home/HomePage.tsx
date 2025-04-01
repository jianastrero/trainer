import TrainerTextLogo from "../../atom/TrainerTextLogo.tsx";
import {StatusBar, View, StyleSheet,} from "react-native";
import useTrainerTheme from "../../theme/TrainerTheme.ts";
import {DarkModeToggle} from "../../atom/DarkModeToggle.tsx";
import {AppBar} from "../../molecule/AppBar.tsx";

export default function HomePage() {
    const theme = useTrainerTheme();

    return (
        <View style={[styles.container, { backgroundColor: theme.colors.background }]}>
            <StatusBar barStyle={theme.isDarkMode ? 'light-content' : 'dark-content'}/>
            <View style={{backgroundColor: theme.colors.background}}>
                <AppBar />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        display: 'flex',
        flex: 1,
        flexDirection: 'column',
        paddingTop: StatusBar.currentHeight,
    },
});

