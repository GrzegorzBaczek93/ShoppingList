package com.grzegorz.baczek.shoppinglist.navigation.service

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.entry.NavEntry
import com.grzegorz.baczek.shoppinglist.navigation.stack.NavStack
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import com.grzegorz.baczek.shoppinglist.navigation.viewmodelstoreprovider.ViewModelStoreProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationService : INavigationService {

    private val viewModelStoreProvider = ViewModelStoreProvider()
    private val currentState = MutableStateFlow<NavState>(NavState.Empty)
    private val navStack = NavStack()

    override val isBackEnabled: Boolean
        get() = navStack.allowPop()

    override fun getCurrentState() = currentState.asStateFlow()

    override fun navigateTo(destination: Destination) {
        createNavEntryAndNavigate(destination)
        updateState()
    }

    override fun pop() {
        popAndClearViewModelStore()
        updateState()
    }

    private fun createNavEntryAndNavigate(destination: Destination) {
        navStack.push(
            NavEntry(
                destination = destination,
                viewModelStore = viewModelStoreProvider.getViewModelStore(destination.id),
            )
        )
    }

    private fun popAndClearViewModelStore() {
        navStack.pop()?.also { viewModelStoreProvider.clearViewModelStore(it.destination.id) }
    }

    private fun updateState() {
        currentState.value = NavState.Entry(
            screenNavEntry = navStack.peek(Destination.Screen::class),
            dialogNavEntry = navStack.peek(Destination.Dialog::class),
        )
        println("State: ${currentState.value}")
    }
}
