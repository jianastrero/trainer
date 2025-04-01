import {StyleProp, StyleSheet, View} from "react-native";
import TrainerTextLogo from "../atom/TrainerTextLogo.tsx";
import {DarkModeToggle} from "../atom/DarkModeToggle.tsx";

type AppBarProps = {
    style?: StyleProp<any>;
}

export function AppBar({style}: AppBarProps) {
    return (
        <View style={[styles.container, style]}>
            <TrainerTextLogo />
            <DarkModeToggle />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    }
});