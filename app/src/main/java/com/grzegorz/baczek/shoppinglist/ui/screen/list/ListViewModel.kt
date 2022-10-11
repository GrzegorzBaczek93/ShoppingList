package com.grzegorz.baczek.shoppinglist.ui.screen.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class ListViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<ListArguments>() {

    var state by mutableStateOf<ListScreenState>(ListScreenState.Loading)
        private set

    override fun onArgumentsObtained(args: ListArguments) {
        super.onArgumentsObtained(args)
    }
}
