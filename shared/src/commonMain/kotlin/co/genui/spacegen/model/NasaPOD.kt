package co.genui.spacegen.model

import kotlinx.serialization.*
import kotlinx.serialization.internal.*

@Serializable
class NasaPOD(
    val date: String, // Don't try to serialize as GMTDate, not implemented yet
    val explanation: String,
    val hdurl: String,
    @SerialName("media_type")
    val mediaType: String,
    @SerialName("service_version")
    val serviceVersion: String,
    val title: String,
    val url: String
)
    


