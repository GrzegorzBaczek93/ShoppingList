package com.grzegorz.baczek.shoppinglist.navigation.action

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationHandler {

    private val currentAction = MutableStateFlow<NavigationAction>(NavigationAction.None)

    fun getActionFlow() = currentAction.asStateFlow()

    fun navigateTo(destination: Destination) {
        currentAction.value = NavigationAction.NavigateTo(destination)
    }

    fun popTo(destination: Destination) {
        currentAction.value = NavigationAction.PopTo(destination)
    }

    fun pop() {
        currentAction.value = NavigationAction.Pop
    }
}
