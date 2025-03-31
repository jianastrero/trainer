# <img src="../trainer_logo.png" width="24" heigh="24"/> Trainér
<hr/>
This is a Kotlin Multiplatform project targeting Android, iOS.
<hr/>
Trainér is the dating app for Pokemon enthusiasts! Discover and connect with Pokemon in your area. Swipe right on those you're attracted to, and if they swipe right back, it's a match! Build your ultimate team of companions and explore the world of Pokemon dating.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
    - `commonMain` is for code that’s common for all targets.
    - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
      For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
      `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

## Screen Shots
## Android
| Home                                                     | Matches                                                     | Detail                                                     |
|----------------------------------------------------------|-------------------------------------------------------------|------------------------------------------------------------|
| <img src="../screenshots/android/home.png" width="256"/> | <img src="../screenshots/android/matches.png" width="256"/> | <img src="../screenshots/android/detail.png" width="256"/> |

## iOS
| Home                                                 | Matches                                                 | Detail                                                 |
|------------------------------------------------------|---------------------------------------------------------|--------------------------------------------------------|
| <img src="../screenshots/ios/home.png" width="256"/> | <img src="../screenshots/ios/matches.png" width="256"/> | <img src="../screenshots/ios/detail.png" width="256"/> |
