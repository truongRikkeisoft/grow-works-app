package com.trinity.growworks.data.database.remote.source

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.domain.state.remotestate.DataState
import kotlinx.coroutines.flow.Flow

interface EpisodesRemoteDataSource {
    suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
}