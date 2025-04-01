import {Image, StyleProp, StyleSheet, Text, TouchableOpacity, View} from "react-native";
import useTrainerTheme from "../theme/TrainerTheme.ts";

type PokemonListItemProps = {
    name: string;
    imageUrl: string;
    onPress: () => void;
    style?: StyleProp<any>;
};

export function PokemonListItem({name, imageUrl, onPress, style}: PokemonListItemProps) {
    const theme = useTrainerTheme();

    return (
        <View style={styles.container}>
            <TouchableOpacity style={[styles.itemContainer, style]}
                              onPress={onPress}>
                <Image src={imageUrl} style={styles.image}/>
                <Text style={[styles.text, {color: theme.colors.onBackground}]}>{name}</Text>
            </TouchableOpacity>
            <View style={styles.divider}/>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        width: '100%',
    },
    itemContainer: {
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center',
        padding: 16,
        width: '100%',
    },
    image: {
        width: 64,
        height: 64,
        marginRight: 12,
    },
    text: {
        fontSize: 24,
        fontWeight: 'bold',
    },
    divider: {
        height: 1,
        backgroundColor: '#ccc',
        width: '80%',
    }
});
