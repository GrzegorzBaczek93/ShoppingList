package com.grzegorz.baczek.shoppinglist.service.navigation

sealed class NavDestination(
    val route: String,
) {
    object Home: NavDestination(route = "Home")
    object Item: NavDestination(route = "Item")
}
