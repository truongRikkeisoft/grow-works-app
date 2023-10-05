package com.trinity.growworks.presentation.screen.compose.episodes_local.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.trinity.growworks.presentation.screen.compose.episodes_local.EpisodesLocalScreen
import com.trinity.growworks.utils.constain.ScreenRoute

fun NavGraphBuilder.episodesLocalScreen() {
    composable(route = ScreenRoute.EPISODES_LOCAL_NAVIGATION_ROUTE) {
        EpisodesLocalScreen(viewModel = hiltViewModel())
    }
}