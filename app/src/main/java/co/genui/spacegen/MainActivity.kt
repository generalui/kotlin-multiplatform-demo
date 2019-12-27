package co.genui.spacegen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import co.genui.spacegen.services.NasaApi
import co.genui.spacegen.services.NasaApiService
import com.genui.spacegen.ApplicationContext
import com.genui.spacegen.utils.SettingsManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val settingsManager = SettingsManager(ApplicationContext(this))
        val storedUsername = settingsManager.getUsername()
        Log.d("STORED", "$storedUsername")

        val username = "joey"
        settingsManager.saveUsername(username)

    }
}
