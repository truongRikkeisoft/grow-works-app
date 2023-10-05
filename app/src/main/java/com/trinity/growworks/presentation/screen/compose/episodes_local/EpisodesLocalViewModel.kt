package com.trinity.growworks.presentation.screen.compose.episodes_local

import androidx.lifecycle.viewModelScope
import com.trinity.growworks.domain.usecase.episodes.GetAllEpisodesRealmUseCase
import com.trinity.growworks.domain.state.viewstate.IViewEvent
import com.trinity.growworks.domain.state.viewstate.episodes.EpisodesLocalViewState
import com.trinity.growworks.core.presentation.BaseViewModel
import com.trinity.growworks.presentation.screen.compose.episodes.EpisodesViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesLocalViewModel @Inject constructor(
    private val getAllEpisodesRealmUseCase: GetAllEpisodesRealmUseCase
) : BaseViewModel<EpisodesLocalViewState, EpisodesViewEvent>() {

    init {
        getALlEpisodes()
    }

    override fun createInitialState(): EpisodesLocalViewState = EpisodesLocalViewState()

    override fun onTriggerEvent(event: EpisodesViewEvent) {}

    private fun getALlEpisodes() {
        viewModelScope.launch {
            getAllEpisodesRealmUseCase.invoke(Any()).collect {
                setState { currentState.copy(data = it) }
            }
        }
    }

}

sealed class EpisodesLocalViewEvent() : IViewEvent {}