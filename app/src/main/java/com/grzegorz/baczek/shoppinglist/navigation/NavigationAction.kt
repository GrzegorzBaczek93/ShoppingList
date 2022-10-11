package com.grzegorz.baczek.shoppinglist.navigation

sealed class NavigationAction {
    data class NavigateTo(val screen: Screen) : NavigationAction()
    object Pop : NavigationAction()
    object None : NavigationAction()
}
