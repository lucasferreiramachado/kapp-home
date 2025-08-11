package com.lucasferreiramachado.kapp.home.compose.example.ui.navigation

import kotlinx.serialization.Serializable

sealed class ExampleNavigationRoute {
    @Serializable data object ExampleScreen: ExampleNavigationRoute()
}