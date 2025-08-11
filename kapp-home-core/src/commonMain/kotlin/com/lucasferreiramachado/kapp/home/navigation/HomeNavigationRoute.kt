package com.lucasferreiramachado.kapp.home.navigation

import kotlinx.serialization.Serializable

sealed class HomeNavigationRoute {
    @Serializable data class HomeScreen(val username: String): HomeNavigationRoute()
}