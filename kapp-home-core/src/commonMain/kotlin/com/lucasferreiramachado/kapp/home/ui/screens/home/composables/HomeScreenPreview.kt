package com.lucasferreiramachado.kapp.home.ui.screens.home.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiEvent
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiState
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel

@Composable
fun previewHomeScreen(
    state: HomeUiState,
    events: List<HomeUiEvent>
) {
    val viewModel = HomeViewModel(state)
    events.forEach {  event -> viewModel.onEvent(event) }
    HomeScreen(
        viewModel
    )
}