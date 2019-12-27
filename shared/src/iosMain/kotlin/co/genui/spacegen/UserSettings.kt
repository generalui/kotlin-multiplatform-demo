package com.genui.spacegen

import platform.Foundation.NSUserDefaults
import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings

actual fun globalUserSettings(context: ApplicationContext): Settings {
    val userDefaults = NSUserDefaults.standardUserDefaults
    return AppleSettings(userDefaults)
}

actual class ApplicationContext
