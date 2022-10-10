package com.grzegorz.baczek.shoppinglist.navigation

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.rememberNavController

@Composable
fun Navigation() {
    val navHostController = rememberNavController<Screen>(startDestination = Screen.Home(HomeArguments()))

    NavBackHandler(controller = navHostController)

    NavHost(navHostController) { screen -> screen.Content(navHostController) }
}