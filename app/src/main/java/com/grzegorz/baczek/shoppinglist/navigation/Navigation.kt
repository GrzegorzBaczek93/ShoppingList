package com.grzegorz.baczek.shoppinglist.navigation

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeScreen
import com.grzegorz.baczek.shoppinglist.ui.screen.list.compose.ListScreen
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.rememberNavController

@Composable
fun Navigation() {
    val navHostController = rememberNavController<Screen>(startDestination = Screen.Home(HomeArguments()))

    NavBackHandler(controller = navHostController)

    NavHost(navHostController) { screen ->
        when (screen) {
            is Screen.Home -> HomeScreen(navHostController, screen.arguments)
            is Screen.List -> ListScreen(navHostController, screen.arguments)
        }
    }
}