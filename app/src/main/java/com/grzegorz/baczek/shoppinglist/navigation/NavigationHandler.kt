package com.grzegorz.baczek.shoppinglist.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationHandler {

    private val currentAction = MutableStateFlow<NavigationAction>(NavigationAction.None)

    fun getActionFlow() = currentAction.asStateFlow()

    fun navigateTo(screen: Screen) {
        currentAction.value = NavigationAction.NavigateTo(screen)
    }

    fun pop() {
        currentAction.value = NavigationAction.Pop
    }
}
