package com.lucasferreiramachado.kapp.home.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinator

interface HomeCoordinatorFactoryI {

    fun create(parent: KCoordinator<*>): HomeCoordinator
}