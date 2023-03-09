package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("added_at")
    val addedAt: String,
    @SerialName("added_by")
    val addedBy: AddedBy,
    @SerialName("is_local")
    val isLocal: Boolean,
    @SerialName("track")
    val track: Track,

)