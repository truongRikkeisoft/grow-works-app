package com.trinity.growworks.domain.usecase.episodes

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.core.domain.BaseUseCase
import com.trinity.growworks.core.domain.IParams
import com.trinity.growworks.domain.repository.remote.EpisodesRepository
import com.trinity.growworks.domain.state.remotestate.DataState
import kotlinx.coroutines.flow.Flow

class GetAllEpisodesUseCase(
    internal val repository: EpisodesRepository
) : BaseUseCase<IParams, DataState<EpisodesResponse>> {
    override suspend fun invoke(param: IParams): Flow<DataState<EpisodesResponse>> = repository.getAllEpisodes()
}