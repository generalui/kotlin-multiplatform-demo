package co.genui.spacegen.services

import co.genui.spacegen.DateTime
import co.genui.spacegen.model.NasaPOD
import co.genui.spacegen.toYMD
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate

public class NasaApi {

    companion object {
        const val API_KEY = "5cBW8aZycEbICN5o7SZuyKLC6F410IG36kEbfmyI"
        const val endpoint = "https://api.nasa.gov/planetary/apod?api_key=${API_KEY}"
    }

    private val client = HttpClient() {
        install(JsonFeature)
    }

    // date=YYYY-MM-DD
    suspend fun getPictureOfDayMetadata(date: DateTime? = null): NasaPOD = client.get<NasaPOD>(NasaApi.endpoint) {
        parameter("date", date?.let { it.toYMD } ?: "")
    }


    // suspend fun getPictureOfDay(date: Date) -> NasaPOD {


    // }

}
