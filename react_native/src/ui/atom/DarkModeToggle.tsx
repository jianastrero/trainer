import {Appearance, Image, StyleProp, StyleSheet, TouchableOpacity, useColorScheme} from "react-native";
import useTrainerTheme from "../theme/TrainerTheme.ts";

export type DarkModeToggleProps = {
    style?: StyleProp<any>;
};

export function DarkModeToggle({style}: DarkModeToggleProps) {
    const theme = useTrainerTheme();
    const toggleSwitch = () => {
        const newColorScheme = theme.isDarkMode ? 'light' : 'dark';
        Appearance.setColorScheme(newColorScheme);
    };

    return (
        <TouchableOpacity
            style={[style, {padding: 10}]}
            onPress={toggleSwitch} >
            <Image style={styles.icon}
                   source={theme.isDarkMode
                       ? require("../../../assets/img/ic_dark_mode.png")
                       : require("../../../assets/img/ic_light_mode.png")}
                   resizeMode={"contain"}
                   tintColor={theme.colors.onBackground} />
        </TouchableOpacity>
    );
}

const styles = StyleSheet.create({
    icon: {
        width: 24,
        height: 24,
        margin: 4,
    },
});
