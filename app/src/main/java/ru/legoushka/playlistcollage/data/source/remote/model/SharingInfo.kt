package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SharingInfo(
    @SerialName("share_id")
    val shareId: String,
    @SerialName("share_url")
    val shareUrl: String,
    @SerialName("uri")
    val uri: String
)