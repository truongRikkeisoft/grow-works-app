package com.trinity.growworks.data.database.remote.source.impl

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.data.database.remote.api.EpisodesService
import com.trinity.growworks.core.data.BaseRemoteDataSource
import com.trinity.growworks.data.database.remote.source.EpisodesRemoteDataSource
import com.trinity.growworks.domain.state.remotestate.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodesRemoteDataSourceImpl @Inject constructor(
    private val episodesService: EpisodesService
) : BaseRemoteDataSource(), EpisodesRemoteDataSource {
    override suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getAllEpisodes()
    }
}