package com.trinity.growworks.data.database.remote.api

import com.trinity.growworks.domain.model.remote.EpisodesResponse
import com.trinity.growworks.utils.constain.RemoteConstants
import retrofit2.Response
import retrofit2.http.GET

interface EpisodesService {
    @GET(RemoteConstants.EPISODE_LIST)
    suspend fun getAllEpisodes(): Response<EpisodesResponse>
}