package com.lucasferreiramachado.kapp.home.compose.example.ui.screens.example

import com.lucasferreiramachado.kapp.home.compose.example.domain.model.ExampleItem

sealed class ExampleUiEvent {
    data class ItemSelected(val item: ExampleItem) : ExampleUiEvent()
}