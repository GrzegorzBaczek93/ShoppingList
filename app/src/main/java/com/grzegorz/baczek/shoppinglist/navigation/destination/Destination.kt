package com.grzegorz.baczek.shoppinglist.navigation.destination

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose.CheckListScreen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeScreen
import com.grzegorz.baczek.shoppinglist.utils.base.BaseScreenArguments

interface Destination {
    val id: String
        get() = this::class.qualifiedName!!
    val arguments: BaseScreenArguments

    @Composable
    fun Content() {
    }

    sealed class Screen : Destination {
        data class Home(override val arguments: HomeArguments) : Screen() {
            @Composable
            override fun Content() {
                HomeScreen(arguments = arguments)
            }
        }

        data class CheckList(override val arguments: CheckListArguments) : Screen() {
            @Composable
            override fun Content() {
                CheckListScreen(arguments = arguments)
            }
        }
    }

    sealed class Dialog : Destination {

    }
}