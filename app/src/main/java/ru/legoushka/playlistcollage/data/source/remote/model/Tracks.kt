package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tracks(
    @SerialName("items")
    val items: List<Item>,
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("total")
    val total: Int
)