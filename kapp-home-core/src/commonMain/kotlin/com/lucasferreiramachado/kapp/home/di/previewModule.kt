package com.lucasferreiramachado.kapp.home.di

import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinator
import com.lucasferreiramachado.kapp.home.di.modules.dataModule
import com.lucasferreiramachado.kapp.home.ui.screens.home.HomeViewModel
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinatorAction
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val previewModule: Module = module {

    includes(dataModule)

    single<HomeCoordinator> {
        HomeCoordinator(FakeCoordinator())
    }
    viewModelOf(::HomeViewModel)
}

private class FakeCoordinator() : KCoordinator<KCoordinatorAction> {
    override val parent: KCoordinator<*>? = null
    override fun handle(action: KCoordinatorAction) {}
}