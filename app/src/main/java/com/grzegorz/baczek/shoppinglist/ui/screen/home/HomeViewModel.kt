package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel
import com.grzegorz.baczek.shoppinglist.utils.log.logD
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel<HomeArguments>() {

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Loading)
        private set

    override fun onArgumentsObtained(args: HomeArguments) {
        super.onArgumentsObtained(args)
        logD("onArgumentsObtained")
        viewModelScope.launch {
            delay(5000L)
            state = HomeScreenState.Success
        }
    }
}