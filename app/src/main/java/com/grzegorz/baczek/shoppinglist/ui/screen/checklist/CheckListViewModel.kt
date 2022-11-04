package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class CheckListViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<CheckListArguments>() {

    var viewState by mutableStateOf<CheckListScreenState>(CheckListScreenState.Preview)
        private set

    var checkList by mutableStateOf<CheckList>(CheckList.empty)

    fun onBackButtonClick() {
        navigationHandler.pop()
    }

    fun onSwitchModeClick() {
        when (viewState) {
            CheckListScreenState.Edit -> viewState = CheckListScreenState.Preview
            CheckListScreenState.Preview -> viewState = CheckListScreenState.Edit
            else -> {}
        }
    }

    fun onRenewClick() {
    }

    fun onShareButtonClick() {
    }

    fun onRemoveButtonClick() {
    }
}
