package com.lucasferreiramachado.kapp.home.di.modules

import com.lucasferreiramachado.kapp.data.user.FakeUserRepository
import com.lucasferreiramachado.kapp.data.user.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single<UserRepository> { FakeUserRepository() }
}