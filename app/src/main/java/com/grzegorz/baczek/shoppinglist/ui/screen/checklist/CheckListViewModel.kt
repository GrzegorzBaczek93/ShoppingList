package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class CheckListViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<CheckListArguments>() {

    var viewState by mutableStateOf<CheckListScreenState>(CheckListScreenState.Content)
        private set

    fun onBackButtonClick() {
        navigationHandler.pop()
    }

    fun onShareButtonClick() {

    }

    fun onRemoveButtonClick() {

    }
}
