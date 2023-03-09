package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddedBy(
    @SerialName("external_urls")
    val externalUrls: ExternalUrls,
    @SerialName("id")
    val id: String,
    @SerialName("type")
    val type: String,
    @SerialName("uri")
    val uri: String
)