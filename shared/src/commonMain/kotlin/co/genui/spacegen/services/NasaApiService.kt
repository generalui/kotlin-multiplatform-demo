package co.genui.spacegen.services

import co.genui.spacegen.dispatcher
import co.genui.spacegen.model.NasaPOD
import io.ktor.util.date.GMTDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

public class NasaApiService(private val api: NasaApi) : CoroutineScope {

    override val coroutineContext: CoroutineContext = dispatcher() + SupervisorJob()

    fun getPictureOfDay(completion: (NasaPOD?, Throwable?) -> Unit) {
        val date = GMTDate()
        launch {
            val deferred = async {
                api.getPictureOfDayMetadata(date)
            }
            try {
                val nasaPOD = deferred.await()
                completion(nasaPOD, null)
            } catch (e: Exception) {
                completion(null, e)
            }
        }
    }

}
