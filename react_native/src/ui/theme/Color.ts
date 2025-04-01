const PrimaryColor = '#E53935'
const LightColor = '#ECEFF1'
const DarkColor = '#2C3E50'
const ErrorColor = '#B00020'

export interface Colors {
    primary: string;
    primaryVariant: string;
    secondary: string;
    secondaryVariant: string;
    background: string;
    surface: string;
    error: string;
    onPrimary: string;
    onSecondary: string;
    onBackground: string;
    onSurface: string;
    onError: string;
}

export const TrainerLightColors: Colors = {
    primary: PrimaryColor,
    primaryVariant: PrimaryColor,
    secondary: PrimaryColor,
    secondaryVariant: PrimaryColor,
    background: LightColor,
    surface: LightColor,
    error: ErrorColor,
    onPrimary: LightColor,
    onSecondary: LightColor,
    onBackground: DarkColor,
    onSurface: DarkColor,
    onError: LightColor,
};

export const TrainerDarkColors: Colors = {
    primary: PrimaryColor,
    primaryVariant: PrimaryColor,
    secondary: PrimaryColor,
    secondaryVariant: PrimaryColor,
    background: DarkColor,
    surface: DarkColor,
    error: ErrorColor,
    onPrimary: LightColor,
    onSecondary: LightColor,
    onBackground: LightColor,
    onSurface: LightColor,
    onError: LightColor,
};
