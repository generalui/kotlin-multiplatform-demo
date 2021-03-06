# SpaceGen Kotlin Multiplatform demo
SpaceGen demos some basic capabilities of Kotlin multiplatform for Android/iOS/JavaScript. Different branches demonstrate different multiplatform capabilities:

## Branches
1. **master**: Expect/actual using platform-specific strings.
2. **http**: Shared network service using JetBrains ktor library.
3. **settings**: Platform-specific local storage/settings (viz., SharedPrefs/UserDefaults) within shared code.
4. **sqlite**: Shared sqlite using 3rd party SqlDelight library.
5. **images**: Enable native "image" type to be received back from shared api
5. **dates**: Enable native "date" type to be passed into shared api

---------------------------------------------------------
Note: SpaceGen was originally planned as a demo based on Nasa's Picture-of-the-Day api, whence the name.
