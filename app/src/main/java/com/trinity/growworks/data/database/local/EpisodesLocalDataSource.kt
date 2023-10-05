package com.trinity.growworks.data.database.local

import com.trinity.growworks.data.model.local.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodesLocalDataSource {

    suspend fun insertEpisode(episodes: List<Episode>)

    fun getAllEpisode(): Flow<List<Episode>>
}