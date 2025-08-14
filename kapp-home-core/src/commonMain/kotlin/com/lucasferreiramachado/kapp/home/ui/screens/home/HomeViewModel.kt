package com.lucasferreiramachado.kapp.home.ui.screens.home

import androidx.lifecycle.ViewModel
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinatorAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class  HomeViewModel(
    initialState: HomeUiState = HomeUiState(),
    var coordinator: KCoordinator<HomeCoordinatorAction>? = null
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    
    fun onEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.SignOutButtonPressed -> {
                coordinator?.trigger(HomeCoordinatorAction.SignOut)
            }
            is HomeUiEvent.ProductsButtonPressed -> {
                coordinator?.trigger(HomeCoordinatorAction.StartProductListFlow)
            }
        }
    }
}

