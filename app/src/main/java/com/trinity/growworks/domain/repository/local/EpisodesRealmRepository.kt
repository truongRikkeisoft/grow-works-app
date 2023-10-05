package com.trinity.growworks.domain.repository.local

import com.trinity.growworks.data.model.local.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodesRealmRepository {

    suspend fun insertEpisode(episodes: List<Episode>)

    fun getAllEpisode(): Flow<List<Episode>>
}