package ru.legoushka.playlistcollage.data.source.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.legoushka.playlistcollage.data.MetadataProvider
import ru.legoushka.playlistcollage.data.source.DataSource
import ru.legoushka.playlistcollage.data.source.remote.model.PlaylistResponse

class RemoteDataSource(
    private val httpClient: HttpClient,
    private val apiMetadataProvider: MetadataProvider<ApiMetadata>,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DataSource {

    override suspend fun getCollageImagesById(id: String): PlaylistResponse = withContext(coroutineDispatcher){
        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = apiMetadataProvider.provide().Host
                appendEncodedPathSegments("playlist_tracks/?id=$id")
            }
            headers{
                append("X-RapidAPI-Key", apiMetadataProvider.provide().Key)
                append("X-RapidAPI-Host", apiMetadataProvider.provide().Host)
            }
        }
        return@withContext response.body<PlaylistResponse>()
    }
}