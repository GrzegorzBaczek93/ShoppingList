package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class CheckListViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<CheckListArguments>() {

    var state by mutableStateOf<CheckListScreenState>(CheckListScreenState.Loading)
        private set

    override fun onArgumentsObtained(args: CheckListArguments) {
        super.onArgumentsObtained(args)
    }
}
