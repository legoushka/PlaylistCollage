package ru.legoushka.playlistcollage.data.source

import ru.legoushka.playlistcollage.data.source.remote.model.PlaylistResponse

interface DataSource {

    suspend fun getCollageImagesById(id: String): PlaylistResponse

}