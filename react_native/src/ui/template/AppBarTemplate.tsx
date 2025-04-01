import {PropsWithChildren} from "react";
import {StyleProp, StyleSheet, View} from "react-native";
import {AppBar} from "../organism/AppBar.tsx";

type AppBarTemplateProps = PropsWithChildren & {
    style?: StyleProp<any>;
}

export function AppBarTemplate({style, children}: AppBarTemplateProps) {
    return (
        <View style={[styles.container, style]}>
            <AppBar />
            {children}
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        display: 'flex',
        flex: 1,
        flexDirection: 'column',
        justifyContent: 'flex-start',
        alignItems: 'flex-start',
    }
});
