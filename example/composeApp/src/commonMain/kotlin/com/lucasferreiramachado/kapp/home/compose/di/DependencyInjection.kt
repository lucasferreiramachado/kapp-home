package com.lucasferreiramachado.kapp.home.compose.di

import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinator
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorFactoryI
import com.lucasferreiramachado.kapp.data.user.UserRepository
import com.lucasferreiramachado.kapp.data.user.model.AuthenticatedUser
import com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator.ExampleCoordinator
import com.lucasferreiramachado.kapp.home.compose.example.ui.coordinator.ExampleCoordinatorFactoryI
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinator
import com.lucasferreiramachado.kapp.home.coordinator.HomeCoordinatorFactoryI
import com.lucasferreiramachado.kcoordinator.KCoordinator

class ExampleCoordinatorFactory(
    override val homeCoordinatorFactory: HomeCoordinatorFactoryI = ExampleHomeCoordinatorFactory(),
    override val authCoordinatorFactory: AuthCoordinatorFactoryI = ExampleAuthCoordinatorFactory(),
): ExampleCoordinatorFactoryI{
    override fun create(

        parent: KCoordinator<*>,
    ): ExampleCoordinator =  ExampleCoordinator(
        factory = this,
        parent = parent
    )
}

private class ExampleAuthCoordinatorFactory(
    override val authenticateUserUseCase: AuthenticateUserUseCase = AuthenticateUserUseCase(
        repository = ExampleUserRepositoryFactory.create()
    ),
) : AuthCoordinatorFactoryI {
    override fun create(
        parent: KCoordinator<*>,
    ): AuthCoordinator = AuthCoordinator(
        this,
        parent = parent
    )
}

private class ExampleHomeCoordinatorFactory(): HomeCoordinatorFactoryI {
    override fun create(
        parent: KCoordinator<*>,
    ): HomeCoordinator = HomeCoordinator(
        factory = this,
        parent = parent
    )
}

private object ExampleUserRepositoryFactory {
    private val repository: UserRepository = ExampleUserRepository()

    fun create(): UserRepository {
        return repository
    }
}

private class ExampleUserRepository(
    private var authenticatedUser: AuthenticatedUser? = null
): UserRepository {

    override fun authenticate(
        username: String,
        password: String,
    ): AuthenticatedUser? {
        authenticatedUser = AuthenticatedUser(
            id = "123",
            username = username,
            name = "{user's firstname}"
        )
        return authenticatedUser
    }

    override fun loggedUser(): AuthenticatedUser? = authenticatedUser
}