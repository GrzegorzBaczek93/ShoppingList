package com.grzegorz.baczek.shoppinglist.ui.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.grzegorz.baczek.shoppinglist.navigation.action.NavigationAction
import com.grzegorz.baczek.shoppinglist.navigation.action.NavigationHandler
import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.destination.Dialog
import com.grzegorz.baczek.shoppinglist.navigation.destination.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navController
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.pop
import dev.olshevski.navigation.reimagined.popAll
import dev.olshevski.navigation.reimagined.popUpTo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NavigationViewModel(
    savedStateHandle: SavedStateHandle,
    private val navigationHandler: NavigationHandler,
) : ViewModel() {

    @OptIn(SavedStateHandleSaveableApi::class)
    private val navController by savedStateHandle.saveable<NavController<Destination>> {
        navController<Destination>(startDestination = Screen.Home(HomeArguments()))
    }

    @OptIn(SavedStateHandleSaveableApi::class)
    private val dialogNavController by savedStateHandle.saveable<NavController<Destination>> {
        navController<Destination>(emptyList())
    }

    val backStack get() = navController.backstack
    val backEnabled get() = navController.backstack.entries.size > 1
    val dialogBackStack get() = dialogNavController.backstack

    init {
        navigationHandler.getActionFlow().onEach { handleAction(it) }.launchIn(viewModelScope)
    }

    fun onBackPress() {
        navigationHandler.pop()
    }

    private fun handleAction(action: NavigationAction) {
        when (action) {
            is NavigationAction.NavigateTo -> navigateTo(action.destination)
            is NavigationAction.PopTo -> popTo(action.destination)
            NavigationAction.Pop -> pop()
            NavigationAction.None -> {}
        }
    }

    private fun navigateTo(destination: Destination) {
        when (destination) {
            is Screen -> navController.navigate(destination)
            is Dialog -> dialogNavController.navigate(destination)
        }
    }

    private fun popTo(destination: Destination) {
        if (dialogBackStack.entries.isNotEmpty()) {
            dialogNavController.popAll()
        }
        navController.popUpTo { it == destination }
    }

    private fun pop() {
        when {
            dialogBackStack.entries.isNotEmpty() -> dialogNavController.pop()
            else -> navController.pop()
        }
    }
}
