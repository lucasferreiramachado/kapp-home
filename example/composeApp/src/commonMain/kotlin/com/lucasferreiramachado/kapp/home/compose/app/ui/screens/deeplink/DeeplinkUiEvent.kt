package com.lucasferreiramachado.kapp.home.compose.app.ui.screens.deeplink

sealed class DeeplinkUiEvent {
    data object OnBackPressed : DeeplinkUiEvent()
}