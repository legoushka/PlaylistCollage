package ru.legoushka.playlistcollage.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import ru.legoushka.playlistcollage.data.MetadataProvider
import ru.legoushka.playlistcollage.data.source.remote.ApiMetadata
import ru.legoushka.playlistcollage.data.source.remote.ApiMetadataProvider
import ru.legoushka.playlistcollage.data.source.remote.RemoteDataSource
import ru.legoushka.playlistcollage.presentation.theme.PlaylistCollageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val httpClient = HttpClient(Android) {
            install(ContentNegotiation){
                json(Json { ignoreUnknownKeys = true })
            }
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
        val metadataProvider: MetadataProvider<ApiMetadata> = ApiMetadataProvider()
        val remoteDataSource = RemoteDataSource(httpClient = httpClient, apiMetadataProvider = metadataProvider)


        setContent {
            PlaylistCollageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    var text by remember {mutableStateOf("Playlist title")}
                    Button(onClick = {
                        runBlocking {
                            val response = remoteDataSource.getCollageImagesById("6v2sm7e2dwhsqjoovYNaJR%3Fsi%3Dd4fdae82d71b4cb6")
                            text = response.name
                        }
                    }) {
                        Text(text = text)
                    }
                }
            }
        }
    }
}

