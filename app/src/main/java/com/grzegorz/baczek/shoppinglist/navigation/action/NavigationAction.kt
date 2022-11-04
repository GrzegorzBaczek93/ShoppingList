package com.grzegorz.baczek.shoppinglist.navigation.action

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination

sealed class NavigationAction {
    data class NavigateTo(val destination: Destination) : NavigationAction()
    data class PopTo(val destination: Destination) : NavigationAction()
    object Pop : NavigationAction()
    object None : NavigationAction()
}
