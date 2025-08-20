package com.lucasferreiramachado.kapp.home.di

import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinator
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import com.lucasferreiramachado.kcoordinator.KCoordinator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule: Module = module {
    single<HomeCoordinator> {
        (parent: KCoordinator<*>) -> HomeCoordinator(parent)
    }
    viewModelOf(::HomeViewModel)
}