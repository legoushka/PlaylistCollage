package ru.legoushka.playlistcollage.data.source.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistResponse(
    @SerialName("collaborative")
    val collaborative: Boolean,
    @SerialName("description")
    val description: String,
    @SerialName("external_urls")
    val externalUrls: ExternalUrls,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<Image>,
    @SerialName("name")
    val name: String,
    @SerialName("owner")
    val owner: Owner,
    @SerialName("public")
    val `public`: Boolean,
    @SerialName("sharing_info")
    val sharingInfo: SharingInfo,
    @SerialName("snapshot_id")
    val snapshotId: String,
    @SerialName("tracks")
    val tracks: Tracks,
    @SerialName("type")
    val type: String,
    @SerialName("uri")
    val uri: String
)