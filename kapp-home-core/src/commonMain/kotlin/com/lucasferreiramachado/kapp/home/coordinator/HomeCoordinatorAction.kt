package com.lucasferreiramachado.kapp.home.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction
sealed class HomeCoordinatorAction: KCoordinatorAction {
    data class ShowHomeScreen(val username: String) : HomeCoordinatorAction()
    data object SignOut : HomeCoordinatorAction()
    data object GoBack : HomeCoordinatorAction()
    data object StartProductListFlow : HomeCoordinatorAction()
}