package com.lucasferreiramachado.kapp.home.compose

import androidx.compose.ui.unit.DpSize

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        state = WindowState(
            size = DpSize(width = 400.dp, height = 800.dp),
        ),
        onCloseRequest = ::exitApplication,
        title = "kapp-home Example"
    ) {
        App()
    }
}

