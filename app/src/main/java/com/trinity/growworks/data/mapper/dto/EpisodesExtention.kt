package com.trinity.growworks.data.mapper.dto

import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.data.model.remote.EpisodesResultResponse
import io.realm.kotlin.types.RealmUUID

fun EpisodesResultResponse.toEpisode() = Episode().apply {
    id = (this@toEpisode.id ?: RealmUUID.random().toString()).toString()
    name = this@toEpisode.name
    airDate = this@toEpisode.airDate
    episode = this@toEpisode.episode
}

fun List<EpisodesResultResponse>.toEpisodeList() = map { it.toEpisode() }