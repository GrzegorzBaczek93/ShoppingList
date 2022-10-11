package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class HomeViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<HomeArguments>() {

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Loading)
        private set

    override fun onArgumentsObtained(args: HomeArguments) {
        super.onArgumentsObtained(args)
        state = HomeScreenState.Content
    }

    fun onButtonClicked() {
        navigationHandler.navigateTo(Screen.List(ListArguments(0)))
    }
}
