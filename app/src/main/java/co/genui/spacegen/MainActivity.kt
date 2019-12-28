package co.genui.spacegen.app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import co.genui.spacegen.ApplicationContext
import co.genui.spacegen.PlanetRepo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val repo = PlanetRepo("planets.db", ApplicationContext(this))
        val planetNames = repo.getPlanetNames()
        planetNames.forEach {
            Log.d("PLANETS", it)
        }
    }
}
