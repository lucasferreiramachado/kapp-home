package com.lucasferreiramachado.kapp.home.compose.di

import com.lucasferreiramachado.kapp.auth.login.di.authModule
import com.lucasferreiramachado.kapp.home.compose.app.ui.coordinator.AppCoordinator
import com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator.ExampleCoordinator
import com.lucasferreiramachado.kapp.home.compose.di.modules.dataModule
import com.lucasferreiramachado.kapp.home.di.homeModule
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    includes(dataModule)
    includes(authModule)
    includes(homeModule)

    single<ExampleCoordinator> { (parent: AppCoordinator) -> ExampleCoordinator(parent) }
    single<AppCoordinator> { AppCoordinator() }
}