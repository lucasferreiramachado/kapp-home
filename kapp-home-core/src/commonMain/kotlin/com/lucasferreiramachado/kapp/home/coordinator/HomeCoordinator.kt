package com.lucasferreiramachado.kapp.home.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavUri
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lucasferreiramachado.kapp.deeplink.builder.LoginDeeplinkBuilder
import com.lucasferreiramachado.kapp.deeplink.builder.ProductListDeeplinkBuilder
import com.lucasferreiramachado.kapp.home.navigation.HomeNavigationRoute
import com.lucasferreiramachado.kapp.home.navigation.homeNavigation
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiState
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import com.lucasferreiramachado.kapp.home.ui.screens.home.composables.HomeScreen
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.compose.ComposeKCoordinator

class HomeCoordinator(
    val factory: HomeCoordinatorFactoryI,
    override val parent: KCoordinator<*>
) : ComposeKCoordinator<HomeCoordinatorAction> {

    private var navHostController: NavHostController? = null

    override fun handle(action: HomeCoordinatorAction) {
        when (action) {
            is HomeCoordinatorAction.ShowHomeScreen -> {
                val username = action.username
                navHostController?.popBackStack()
                navHostController?.navigate(HomeNavigationRoute.HomeScreen(username = username))
            }
            is HomeCoordinatorAction.SignOut -> {
                navHostController?.popBackStack()
                val uriString = LoginDeeplinkBuilder().build()
                navHostController?.navigate(NavUri(uriString))
            }
            is HomeCoordinatorAction.GoBack -> {
                navHostController?.popBackStack()
            }
            is HomeCoordinatorAction.StartProductListFlow -> {
                val uriString = ProductListDeeplinkBuilder().build()
                navHostController?.navigate(NavUri(uriString))
            }
        }
    }
    override fun setupNavigation(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        this.navHostController = navHostController
        navGraphBuilder.homeNavigation(this)
    }
}