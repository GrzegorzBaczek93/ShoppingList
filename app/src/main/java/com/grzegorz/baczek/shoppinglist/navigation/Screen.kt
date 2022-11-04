package com.grzegorz.baczek.shoppinglist.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose.CheckListScreen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeScreen
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments
import kotlinx.parcelize.Parcelize

sealed class Screen(
    open val arguments: BaseArguments
) : Parcelable {

    @Composable
    open fun Content() {}

    @Parcelize
    data class Home(override val arguments: HomeArguments) : Screen(arguments) {
        @Composable
        override fun Content() {
            HomeScreen(arguments)
        }
    }

    @Parcelize
    data class CheckList(override val arguments: CheckListArguments) : Screen(arguments) {
        @Composable
        override fun Content() {
            CheckListScreen(arguments)
        }
    }
}
