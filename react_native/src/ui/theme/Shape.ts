import {StyleSheet} from "react-native";

export interface Shape {
    small: {
        borderRadius: number;
    };
    medium: {
        borderRadius: number;
    };
    large: {
        borderRadius: string;
    };
}

export const TrainerShapes: Shape = StyleSheet.create({
    small: {
        borderRadius: 8,
    },
    medium: {
        borderRadius: 32,
    },
    large: {
        borderRadius: '50%',
    }
});
