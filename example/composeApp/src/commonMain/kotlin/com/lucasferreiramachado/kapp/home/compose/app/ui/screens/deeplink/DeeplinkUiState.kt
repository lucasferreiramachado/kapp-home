package com.lucasferreiramachado.kapp.home.compose.app.ui.screens.deeplink

data class DeeplinkUiState(
    val deeplinkUri: String,
    val showBackButton: Boolean = false,
)