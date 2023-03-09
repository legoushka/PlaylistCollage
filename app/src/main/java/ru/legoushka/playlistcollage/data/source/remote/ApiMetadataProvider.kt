package ru.legoushka.playlistcollage.data.source.remote

import ru.legoushka.playlistcollage.BuildConfig
import ru.legoushka.playlistcollage.data.MetadataProvider

class ApiMetadataProvider : MetadataProvider<ApiMetadata> {
    override fun provide(): ApiMetadata {
        return ApiMetadata(BuildConfig.API_KEY, BuildConfig.API_HOST)
    }
}