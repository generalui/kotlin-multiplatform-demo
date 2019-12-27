package com.genui.spacegen

import android.app.Activity
import android.content.*
import android.preference.*
import com.russhwolf.settings.AndroidSettings
import com.russhwolf.settings.Settings

actual fun globalUserSettings(context: ApplicationContext): Settings {
    val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context.activity)
    return AndroidSettings(sharedPrefs)
}

actual class ApplicationContext(
    val activity: Activity
)
