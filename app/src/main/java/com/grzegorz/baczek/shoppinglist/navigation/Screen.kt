package com.grzegorz.baczek.shoppinglist.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeScreen
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.list.compose.ListScreen
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments
import dev.olshevski.navigation.reimagined.NavController
import kotlinx.parcelize.Parcelize

sealed class Screen(
    open val arguments: BaseArguments
) : Parcelable {

    @Composable
    open fun Content(navController: NavController<Screen>) {}

    @Parcelize
    data class Home(override val arguments: HomeArguments) : Screen(arguments) {
        @Composable
        override fun Content(navController: NavController<Screen>) {
            HomeScreen(navController, arguments)
        }
    }

    @Parcelize
    data class List(override val arguments: ListArguments) : Screen(arguments) {
        @Composable
        override fun Content(navController: NavController<Screen>) {
            ListScreen(navController, arguments)
        }
    }
}