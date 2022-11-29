package com.grzegorz.baczek.shoppinglist.navigation.service

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.entry.NavEntry
import com.grzegorz.baczek.shoppinglist.navigation.stack.NavStack
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import com.grzegorz.baczek.shoppinglist.navigation.viewmodelstoreprovider.ViewModelStoreProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.reflect.KClass

class NavigationService : INavigationService {

    private val viewModelStoreProvider = ViewModelStoreProvider()
    private val currentScreenState = MutableStateFlow<NavState>(NavState.Empty)
    private val currentDialogState = MutableStateFlow<NavState>(NavState.Empty)
    private val navStack = NavStack()

    override val isBackEnabled: Boolean
        get() = navStack.allowPop()

    override fun getCurrentScreenState() = currentScreenState.asStateFlow()

    override fun getCurrentDialogState() = currentDialogState.asStateFlow()

    override fun navigateTo(destination: Destination) {
        createNavEntryAndNavigate(destination)
        updateState()
    }

    override fun pop() {
        popAndClearViewModelStore()
        updateState()
    }

    override fun <T : Destination> popUntil(destination: KClass<T>) {
        if (navStack.contains(destination)) {
            popUntilInternally(destination)
            updateState()
        }
    }

    private fun createNavEntryAndNavigate(destination: Destination) {
        navStack.push(
            NavEntry(
                destination = destination,
                viewModelStore = viewModelStoreProvider.getViewModelStore(destination.id),
            ),
        )
    }

    private fun popAndClearViewModelStore() {
        navStack.pop()?.also { viewModelStoreProvider.clearViewModelStore(it.destination.id) }
    }

    private fun <T : Destination> popUntilInternally(destination: KClass<T>) {
        var currentEntry = navStack.peek()

        while (currentEntry != null && currentEntry.destination::class != destination) {
            popAndClearViewModelStore()
            currentEntry = navStack.peek()
        }
    }

    private fun updateState() {
        currentScreenState.value = getNewState(Destination.Screen::class)
        currentDialogState.value = getNewState(Destination.Dialog::class)
    }

    private fun <T : Destination> getNewState(type: KClass<T>): NavState =
        navStack.peek(type)?.let { NavState.Entry(it) } ?: NavState.Empty
}
