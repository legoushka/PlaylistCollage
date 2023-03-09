package ru.legoushka.playlistcollage.data

interface MetadataProvider<T> {

    fun provide(): T

}