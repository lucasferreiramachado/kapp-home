package com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorAction
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinatorAction
import com.lucasferreiramachado.kapp.home.compose.example.domain.model.ExampleItem
import com.lucasferreiramachado.kapp.home.compose.example.ui.navigation.ExampleNavigationRoute
import com.lucasferreiramachado.kapp.home.compose.example.ui.screens.example.ExampleUiState
import com.lucasferreiramachado.kapp.home.compose.example.ui.screens.example.ExampleViewModel
import com.lucasferreiramachado.kapp.home.compose.example.ui.screens.example.composables.ExampleScreen
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.compose.ComposeKCoordinator


class ExampleCoordinator(
    val factory: ExampleCoordinatorFactoryI,
    override val parent: KCoordinator<*>? = null
) : ComposeKCoordinator<ExampleCoordinatorAction> {

    private var navHostController: NavHostController? = null

    private var authCoordinator = factory.authCoordinatorFactory.create(parent = this)
    private var homeCoordinator  = factory.homeCoordinatorFactory.create(parent = this)

    override fun handle(action: ExampleCoordinatorAction) {
        when (action) {
            is ExampleCoordinatorAction.StartExample -> {
                navHostController?.navigate(ExampleNavigationRoute.ExampleScreen)
            }
            is ExampleCoordinatorAction.StartHomeFlow -> {
                authCoordinator.trigger(AuthCoordinatorAction.StartLogin { username ->

                    homeCoordinator.trigger(HomeCoordinatorAction.ShowHomeScreen(username = username))
                })
            }
        }
    }

    override fun setupNavigation(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController,
    ) {
        this.navHostController = navHostController

        authCoordinator.setupNavigation(navGraphBuilder, navHostController)
        homeCoordinator.setupNavigation(navGraphBuilder, navHostController)

        navGraphBuilder.composable<ExampleNavigationRoute.ExampleScreen> {
            val items = listOf(
                ExampleItem(
                    name = "Home Flow",
                    action = ExampleCoordinatorAction.StartHomeFlow
                ),
            )
            val initialState = ExampleUiState(items = items)
            val viewModel = ExampleViewModel(
                initialState,
                coordinator = this@ExampleCoordinator
            )
            ExampleScreen(viewModel)
        }
    }
}