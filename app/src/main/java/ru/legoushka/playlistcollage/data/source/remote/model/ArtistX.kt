package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistX(
    @SerialName("external_urls")
    val externalUrls: ExternalUrls,
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("uri")
    val uri: String
)