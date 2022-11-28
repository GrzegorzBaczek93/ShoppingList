package com.grzegorz.baczek.shoppinglist.ui.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.service.INavigationService
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenArguments
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivityViewModel(
    private val navigationService: INavigationService,
) : ViewModel() {
    var state by mutableStateOf<NavState>(NavState.Empty)

    init {
        navigationService.navigateTo(Destination.Screen.Home(HomeScreenArguments()))
        navigationService.getCurrentState().onEach {
            state = it
        }.launchIn(viewModelScope)
    }

    val isBackEnabled
        get() = navigationService.isBackEnabled

    fun goBack() = navigationService.pop()
}
