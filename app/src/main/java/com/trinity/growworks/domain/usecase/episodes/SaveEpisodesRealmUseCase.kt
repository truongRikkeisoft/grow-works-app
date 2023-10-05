package com.trinity.growworks.domain.usecase.episodes

import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.core.domain.BaseUseCase
import com.trinity.growworks.core.domain.IParams
import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveEpisodesRealmUseCase(
    internal val repository: EpisodesRealmRepository
) : BaseUseCase<SaveEpisodesRealmUseCase.Params, Unit> {
    data class Params(
        val episodes: List<Episode>
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Unit> = flow {
        repository.insertEpisode(param.episodes)
        emit(Unit)
    }
}