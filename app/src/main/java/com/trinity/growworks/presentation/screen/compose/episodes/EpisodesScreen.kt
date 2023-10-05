package com.trinity.growworks.presentation.screen.compose.episodes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.trinity.growworks.presentation.ui.component.EpisodesCard
import com.trinity.growworks.presentation.ui.theme.spacing
import kotlinx.coroutines.launch

@Composable
fun EpisodesScreen(
    viewModel: EpisodesViewModel,
    navigateToEpisodesLocalScreen: () -> Unit
) {
    val viewState = viewModel.uiState.collectAsState().value

    LaunchedEffect(key1 = viewModel.uiEvent) {
        launch {
            viewModel.uiEvent.collect {
                when (it) {
                    is EpisodesViewEvent.SnackBarError -> {}
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
    ) {

        if (!viewState.isLoading) {
            Button(
                onClick = { navigateToEpisodesLocalScreen.invoke() },
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.size15)
            ) {
                Text(text = "To episode local")
            }
        }

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