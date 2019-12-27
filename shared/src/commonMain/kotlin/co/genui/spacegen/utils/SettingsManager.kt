package com.genui.spacegen.utils

import com.genui.spacegen.ApplicationContext
import com.genui.spacegen.globalUserSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

// NOTE: There's no point in using this from native code, since it's
// just a wrapper for native libs; the utility lies in the fact that,
// if native code injects ApplicationContext, then it becomes possible
// to create and use this from shared code.

// NOTE: We're using russhwolf lib to simplify things, but it's not
// hard to eliminate this dependency and write actuals for Android/iOS
// ourselves. See kotlinconf-app for an example of how to do it.
class SettingsManager(private val context: ApplicationContext) {
    companion object {
        const val KEY_USERNAME = "KEY_USERNAME"
    }

    val settings: Settings = globalUserSettings(context)

    fun saveUsername(name: String?) {
        settings[KEY_USERNAME] = name ?: null
    }

    fun getUsername(): String? {
        return settings[KEY_USERNAME]
    }
}
