package com.trinity.growworks.presentation.navigation_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.trinity.growworks.presentation.screen.compose.episodes.navigation.episodesScreen
import com.trinity.growworks.presentation.screen.compose.episodes_local.navigation.episodesLocalScreen
import com.trinity.growworks.utils.constain.Graph
import com.trinity.growworks.utils.constain.ScreenRoute

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = ScreenRoute.EPISODES_NAVIGATION_ROUTE
    ) {
        episodesScreen(
            navigateToEpisodesLocalScreen = {
                navController.navigate(ScreenRoute.EPISODES_LOCAL_NAVIGATION_ROUTE)
            }
        )
        episodesLocalScreen()
    }
}