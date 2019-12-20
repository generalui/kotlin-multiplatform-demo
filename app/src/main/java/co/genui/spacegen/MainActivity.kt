package co.genui.spacegen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import co.genui.spacegen.services.NasaApi
import co.genui.spacegen.services.NasaApiService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val service = NasaApiService(NasaApi())
        service.getPictureOfDay() { pod, throwable -> 
            pod?.let {
                print(it)
            }
            throwable?.let {
                print(it)
            }
        }

    }
}
