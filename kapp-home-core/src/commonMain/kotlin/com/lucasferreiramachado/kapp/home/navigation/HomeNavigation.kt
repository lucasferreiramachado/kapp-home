package com.lucasferreiramachado.kapp.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiState
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import com.lucasferreiramachado.kapp.home.ui.screens.home.composables.HomeScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.homeNavigation() {
    composable<HomeNavigationRoute.HomeScreen> {
        val route = it.toRoute<HomeNavigationRoute.HomeScreen>()
        val initialState = HomeUiState(
            username = route.username
        )
        val viewModel = koinViewModel<HomeViewModel> {
            parametersOf(initialState)
        }
        HomeScreen(viewModel)
    }
}