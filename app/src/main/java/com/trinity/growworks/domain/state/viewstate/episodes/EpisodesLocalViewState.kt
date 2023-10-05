package com.trinity.growworks.domain.state.viewstate.episodes

import androidx.compose.runtime.Stable
import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.domain.state.viewstate.IViewState

@Stable
data class EpisodesLocalViewState(
    val data: List<Episode>? = null
) : IViewState