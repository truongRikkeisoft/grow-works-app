package com.trinity.growworks.domain.usecase.episodes

import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.core.domain.BaseUseCase
import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import kotlinx.coroutines.flow.Flow

class GetAllEpisodesRealmUseCase(
    internal val repository: EpisodesRealmRepository
) : BaseUseCase<Any, List<Episode>> {
    override suspend fun invoke(param: Any): Flow<List<Episode>> = repository.getAllEpisode()

}