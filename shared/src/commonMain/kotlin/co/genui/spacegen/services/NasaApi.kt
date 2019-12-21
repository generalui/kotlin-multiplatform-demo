package co.genui.spacegen.services

import co.genui.spacegen.model.NasaPOD
import com.soywiz.korim.bitmap.NativeImage
import com.soywiz.korim.format.nativeImageFormatProvider
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlinx.coroutines.coroutineScope

//typealias NativeImageFormatProviderJvmKt = NativeImageFormatProviderJvm

public class NasaApi {

    companion object {
        const val API_KEY = "5cBW8aZycEbICN5o7SZuyKLC6F410IG36kEbfmyI"
        const val endpoint = "https://api.nasa.gov/planetary/apod?api_key=${API_KEY}"
    }

    private val client = HttpClient() {
        install(JsonFeature)
    }

    suspend fun getPictureOfDayMetadata(date: GMTDate? = null): NasaPOD = client.get<NasaPOD>(NasaApi.endpoint)

    suspend fun getImage(url: String): NativeImage = coroutineScope {
        val bytes = client.get<ByteArray>(url)
        nativeImageFormatProvider.decode(bytes)
    }


    // suspend fun getPictureOfDay(date: Date) -> NasaPOD {


    // }

}
