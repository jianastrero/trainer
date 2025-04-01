/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import {
  Appearance,
  useColorScheme,
  View,
} from 'react-native';

import HomePage from './page/home/HomePage';
import setColorScheme = Appearance.setColorScheme;

function App(): React.JSX.Element {
  setColorScheme('dark');
  return (<HomePage/>);
}

export default App;
