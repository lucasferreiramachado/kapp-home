package com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator

import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorFactoryI
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinatorFactoryI
import com.lucasferreiramachado.kcoordinator.KCoordinator

interface ExampleCoordinatorFactoryI {
    val homeCoordinatorFactory: HomeCoordinatorFactoryI
    val authCoordinatorFactory: AuthCoordinatorFactoryI
    fun create(parent: KCoordinator<*>): ExampleCoordinator
}