package com.trinity.growworks.presentation.screen.compose.episodes.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.trinity.growworks.presentation.screen.compose.episodes.EpisodesScreen
import com.trinity.growworks.utils.constain.ScreenRoute

fun NavGraphBuilder.episodesScreen(navigateToEpisodesLocalScreen: () -> Unit) {
    composable(route = ScreenRoute.EPISODES_NAVIGATION_ROUTE) {
        EpisodesScreen(
            viewModel = hiltViewModel(),
            navigateToEpisodesLocalScreen = { navigateToEpisodesLocalScreen.invoke() })
    }
}