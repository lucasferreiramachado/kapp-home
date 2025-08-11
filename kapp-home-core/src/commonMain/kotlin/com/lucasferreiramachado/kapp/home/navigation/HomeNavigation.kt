package com.lucasferreiramachado.kapp.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinator
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiState
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import com.lucasferreiramachado.kapp.home.ui.screens.home.composables.HomeScreen

fun NavGraphBuilder.homeNavigation(
    coordinator: HomeCoordinator,
) {
    composable<HomeNavigationRoute.HomeScreen> {
        val route = it.toRoute<HomeNavigationRoute.HomeScreen>()

        val initialState = HomeUiState(
            username = route.username
        )
        val viewModel = HomeViewModel(initialState)
        viewModel.coordinator = coordinator
        HomeScreen(viewModel)
    }
}