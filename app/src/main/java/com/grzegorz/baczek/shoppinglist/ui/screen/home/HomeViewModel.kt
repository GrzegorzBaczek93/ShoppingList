package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.service.storage.IRepositoryService
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val navigationHandler: NavigationHandler,
    private val repositoryService: IRepositoryService,
) : BaseViewModel<HomeArguments>() {

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Empty)
        private set

    var searchText by mutableStateOf("")
        private set

    override fun onArgumentsObtained(args: HomeArguments) {
        super.onArgumentsObtained(args)
        observeData()
    }

    private fun observeData() {
        repositoryService.getCheckLists().onEach { data ->
            state = if (data.isEmpty()) HomeScreenState.Empty else HomeScreenState.Content(data)
        }.launchIn(viewModelScope)
    }

    fun onSearchTextChanged(text: String) {
        searchText = text
    }

    fun onAddClick() {
        navigationHandler.navigateTo(Screen.CheckList(CheckListArguments()))
    }

    fun onCancelClick() {
        searchText = ""
    }

    fun onCardClick(id: String) {
        navigationHandler.navigateTo(Screen.CheckList(CheckListArguments(id = id)))
    }
}
