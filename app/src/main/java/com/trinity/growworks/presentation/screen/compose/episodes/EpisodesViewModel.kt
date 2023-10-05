package com.trinity.growworks.presentation.screen.compose.episodes

import androidx.lifecycle.viewModelScope
import com.trinity.growworks.domain.usecase.episodes.GetAllEpisodesUseCase
import com.trinity.growworks.domain.usecase.episodes.SaveEpisodesRealmUseCase
import com.trinity.growworks.domain.state.viewstate.IViewEvent
import com.trinity.growworks.domain.state.viewstate.episodes.EpisodesViewState
import com.trinity.growworks.core.presentation.BaseViewModel
import com.trinity.growworks.domain.state.remotestate.DataState
import com.trinity.growworks.data.mapper.dto.toEpisodeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase,
    private val saveEpisodesRealmUseCase: SaveEpisodesRealmUseCase
) : BaseViewModel<EpisodesViewState, EpisodesViewEvent>() {

    init {
        getAllEpisodes()
    }

    override fun createInitialState(): EpisodesViewState = EpisodesViewState()

    override fun onTriggerEvent(event: EpisodesViewEvent) {}

    private fun getAllEpisodes() {
        viewModelScope.launch {
            setState { currentState.copy(isLoading = true) }
            delay(2000)
            getAllEpisodesUseCase.repository.getAllEpisodes().collect {
                when (it) {
                    is DataState.Success -> {
                        setState { currentState.copy(isLoading = false, data = it.data.results) }

                        if (it.data.results.isNotEmpty()) {
                            val params = SaveEpisodesRealmUseCase.Params(episodes = it.data.results.toEpisodeList())
                            call(saveEpisodesRealmUseCase(param = params))
                        }

                    }

                    is DataState.Error -> {
                        setState { currentState.copy(isLoading = false) }
                        setEvent(EpisodesViewEvent.SnackBarError(it.apiError?.message))
                    }

                    is DataState.Loading -> {
                        setState { currentState.copy(isLoading = true) }
                    }
                }
            }
        }
    }

}

sealed class EpisodesViewEvent() : IViewEvent {
    class SnackBarError(val message: String?) : EpisodesViewEvent()
}