package com.trinity.growworks.data.repository.local

import com.trinity.growworks.data.database.local.EpisodesLocalDataSource
import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EpisodesRealmRepositoryImpl @Inject constructor(
    private val episodesLocalDataSource: EpisodesLocalDataSource
) : EpisodesRealmRepository {
    override suspend fun insertEpisode(episodes: List<Episode>) {
        episodesLocalDataSource.insertEpisode(episodes = episodes)
    }

    override fun getAllEpisode(): Flow<List<Episode>> = flow {
        emitAll(episodesLocalDataSource.getAllEpisode())
    }
}