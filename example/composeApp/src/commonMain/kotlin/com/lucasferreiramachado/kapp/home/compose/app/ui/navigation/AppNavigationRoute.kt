package com.lucasferreiramachado.kapp.home.compose.app.ui.navigation

import kotlinx.serialization.Serializable

sealed class AppNavigationRoute {
    @Serializable data object SplashScreen: AppNavigationRoute()
    @Serializable data object DeeplinkScreen: AppNavigationRoute()
}