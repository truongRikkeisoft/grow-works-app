package com.trinity.growworks.data.repository.remote

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.data.database.remote.source.EpisodesRemoteDataSource
import com.trinity.growworks.domain.repository.remote.EpisodesRepository
import com.trinity.growworks.domain.state.remotestate.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val episodesRemoteDataSource: EpisodesRemoteDataSource
) : EpisodesRepository {
    override fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = flow {
        emitAll(episodesRemoteDataSource.getAllEpisodes())
    }
}