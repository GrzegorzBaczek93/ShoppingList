package com.grzegorz.baczek.shoppinglist.navigation.action

import com.grzegorz.baczek.shoppinglist.navigation.destination.Screen

sealed class NavigationAction {
    data class NavigateTo(val screen: Screen) : NavigationAction()
    data class PopTo(val screen: Screen): NavigationAction()
    object Pop : NavigationAction()
    object None : NavigationAction()
}
