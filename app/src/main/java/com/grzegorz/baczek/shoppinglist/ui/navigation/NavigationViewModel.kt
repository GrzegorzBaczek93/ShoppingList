package com.grzegorz.baczek.shoppinglist.ui.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.grzegorz.baczek.shoppinglist.navigation.NavigationAction
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navController
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.pop
import dev.olshevski.navigation.reimagined.popUpTo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NavigationViewModel(
    savedStateHandle: SavedStateHandle,
    private val navigationHandler: NavigationHandler,
) : ViewModel() {

    @OptIn(SavedStateHandleSaveableApi::class)
    private val navController by savedStateHandle.saveable<NavController<Screen>> {
        navController<Screen>(startDestination = Screen.Home(HomeArguments()))
    }

    val backStack get() = navController.backstack
    val backEnabled get() = navController.backstack.entries.size > 1

    init {
        navigationHandler.getActionFlow().onEach { handleAction(it) }.launchIn(viewModelScope)
    }

    fun onBackPress() {
        navigationHandler.pop()
    }

    private fun handleAction(action: NavigationAction) {
        when (action) {
            is NavigationAction.NavigateTo -> navController.navigate(action.screen)
            is NavigationAction.PopTo -> navController.popUpTo { it == action.screen }
            NavigationAction.Pop -> navController.pop()
            NavigationAction.None -> {}
        }
    }
}
