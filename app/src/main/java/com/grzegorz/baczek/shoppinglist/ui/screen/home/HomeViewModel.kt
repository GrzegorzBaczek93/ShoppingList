package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.navigation.action.NavigationHandler
import com.grzegorz.baczek.shoppinglist.navigation.destination.Screen
import com.grzegorz.baczek.shoppinglist.service.storage.IRepositoryService
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn

class HomeViewModel(
    private val navigationHandler: NavigationHandler,
    private val repositoryService: IRepositoryService,
) : BaseViewModel<HomeArguments>() {

    private val searchFlow = MutableStateFlow("")

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Empty())
        private set

    override fun onArgumentsObtained(args: HomeArguments) {
        super.onArgumentsObtained(args)
        observeData()
    }

    private fun observeData() {
        repositoryService.getCheckLists().combine(searchFlow) { data, searchText ->
            updateState(data, searchText)
        }.launchIn(viewModelScope)
    }

    private fun updateState(data: List<CheckList>, searchText: String) {
        state = when {
            data.isEmpty() -> HomeScreenState.Empty(searchText)
            searchText.isNotBlank() -> {
                val filtered = data.filter { it.title.contains(searchText) }
                when {
                    filtered.isEmpty() -> HomeScreenState.NotFound(searchText)
                    else -> HomeScreenState.Content(searchText, filtered)
                }
            }
            else -> HomeScreenState.Content(searchText, data)
        }
    }

    fun onSearchTextChanged(text: String) {
        searchFlow.value = text
    }

    fun onCancelClick() {
        searchFlow.value = ""
    }

    fun onAddClick() {
        navigationHandler.navigateTo(Screen.CheckList(CheckListArguments()))
    }

    fun onCardClick(id: Int) {
        navigationHandler.navigateTo(Screen.CheckList(CheckListArguments(id = id)))
    }
}
