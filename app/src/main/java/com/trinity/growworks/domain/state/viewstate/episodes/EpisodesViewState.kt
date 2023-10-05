package com.trinity.growworks.domain.state.viewstate.episodes

import androidx.compose.runtime.Stable
import com.trinity.growworks.data.model.remote.EpisodesResultResponse
import com.trinity.growworks.domain.state.viewstate.IViewState

@Stable
data class EpisodesViewState(
    val isLoading: Boolean = false,
    val data: List<EpisodesResultResponse>? = null
) : IViewState
