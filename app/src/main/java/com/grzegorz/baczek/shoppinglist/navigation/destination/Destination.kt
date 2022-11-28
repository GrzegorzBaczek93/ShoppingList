package com.grzegorz.baczek.shoppinglist.navigation.destination

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogArguments
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.compose.DoubleButtonDialog
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListScreenArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose.CheckListScreen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeScreen
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments

interface Destination {
    val id: String
        get() = this::class.qualifiedName!!
    val arguments: BaseArguments

    @Composable
    fun Content() {
    }

    sealed class Screen : Destination {
        data class Home(override val arguments: HomeScreenArguments) : Screen() {
            @Composable
            override fun Content() {
                HomeScreen(arguments = arguments)
            }
        }

        data class CheckList(override val arguments: CheckListScreenArguments) : Screen() {
            @Composable
            override fun Content() {
                CheckListScreen(arguments = arguments)
            }
        }
    }

    sealed class Dialog : Destination {
        data class DoubleButton(override val arguments: DoubleButtonDialogArguments): Dialog() {
            @Composable
            override fun Content() {
                DoubleButtonDialog(arguments = arguments)
            }
        }
    }
}
