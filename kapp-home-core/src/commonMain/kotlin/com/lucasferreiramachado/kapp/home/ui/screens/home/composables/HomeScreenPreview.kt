package com.lucasferreiramachado.kapp.home.ui.screens.home.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.home.di.previewModule
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiEvent
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeUiState
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import org.koin.compose.KoinApplicationPreview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun previewHomeScreen(
    state: HomeUiState,
    events: List<HomeUiEvent>
) {
    KoinApplicationPreview(
        application = { modules(previewModule) }
    ) {
        val viewModel = koinViewModel<HomeViewModel> {
            parametersOf(state)
        }
        events.forEach { event -> viewModel.onEvent(event) }
        HomeScreen(
            viewModel
        )
    }
}