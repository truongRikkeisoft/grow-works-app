package com.trinity.growworks.presentation.screen.compose.episodes_local

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.trinity.growworks.presentation.ui.component.EpisodesCard

@Composable
fun EpisodesLocalScreen(
    viewModel: EpisodesLocalViewModel
) {
    val viewState = viewModel.uiState.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = viewState.data ?: listOf()) { item ->
                EpisodesCard(
                    name = item.name.orEmpty(),
                    date = item.airDate.orEmpty(),
                    episode = item.episode.orEmpty()
                )
            }
        }
    }
}