package com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction

sealed class ExampleCoordinatorAction: KCoordinatorAction {
    data object StartExample : ExampleCoordinatorAction()
    data object StartHomeFlow : ExampleCoordinatorAction()
}