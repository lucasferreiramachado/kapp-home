package com.lucasferreiramachado.kapp.home.compose.di

import org.koin.dsl.koinConfiguration

val KoinApp = koinConfiguration {
    modules(
        appModule
    )
}