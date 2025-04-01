import {Colors, TrainerDarkColors, TrainerLightColors} from "./Color.ts";
import {useColorScheme, StyleSheet} from "react-native";
import {Shape, TrainerShapes} from "./Shape.ts";
import {Typography} from "./Typography.ts";
import {useMemo} from "react";

export interface Theme {
    isDarkMode: boolean;
    colors: Colors;
    shapes: Shape;
    typography: Typography;
}

const useTrainerTheme = (): Theme => {
    const isLightMode = useColorScheme() === 'light';
    const colors: Colors = useMemo(() => {
        return isLightMode ? TrainerLightColors : TrainerDarkColors
    }, [isLightMode]);

    const TrainerTypography: Typography = useMemo(() => {
        return StyleSheet.create({
            subtitle1: {
                color: colors.onBackground,
                fontSize: 14,
                fontWeight: "100",
                lineHeight: 14,
                textAlign: 'center'
            },
            body1: {
                color: colors.onBackground,
                fontSize: 16,
                fontWeight: "300",
                lineHeight: 16,
                textAlign: 'center'
            },
            button: {
                color: colors.primary,
                fontSize: 24,
                fontWeight: "900",
                lineHeight: 24,
                textAlign: 'center'
            }
        });
    }, [colors.onBackground, colors.primary]);

    return useMemo(() => ({
        isDarkMode: !isLightMode,
        colors: colors,
        shapes: TrainerShapes,
        typography: TrainerTypography
    }), [isLightMode, colors, TrainerTypography]);
}

export default useTrainerTheme;
