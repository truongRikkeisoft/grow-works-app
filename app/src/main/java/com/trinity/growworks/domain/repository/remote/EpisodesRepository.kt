package com.trinity.growworks.domain.repository.remote

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.domain.state.remotestate.DataState
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
}