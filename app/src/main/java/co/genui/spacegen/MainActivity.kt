package co.genui.spacegen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import co.genui.spacegen.services.NasaApi
import co.genui.spacegen.services.NasaApiService
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val service = NasaApiService(NasaApi())
        val yesterday = getYesterdayDate()
        service.getPictureOfDay(yesterday) { pod, throwable -> 
            pod?.let {
                main_text.text = it.title
            }
            throwable?.let {
                main_text.text = it.message ?: "Unknown error"
            }
        }

    }

    private fun getYesterdayDate(): Date {
        val now = Instant.now()
        val yesterday = now.minus(1, ChronoUnit.DAYS)
        return Date.from(yesterday)
    }

}
