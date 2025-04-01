import {Image, StyleProp, StyleSheet} from "react-native";

export type TrainerTextLogoProps = {
    style?: StyleProp<any>;
};

export default function TrainerTextLogo({style}: TrainerTextLogoProps) {
    return (
        <Image
            source={require("../../../assets/img/trainer_text_logo.png")}
            style={[style, styles.image]}
            resizeMode={"contain"} />
    );
}

const styles = StyleSheet.create({
    image: {
        width: 117,
        height: 24,
        margin: 4
    },
});
