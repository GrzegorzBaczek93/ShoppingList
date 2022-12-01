package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.service.INavigationService
import com.grzegorz.baczek.shoppinglist.service.storage.IRepositoryService
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListScreenArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn

class HomeScreenViewModel(
    private val repositoryService: IRepositoryService,
    private val navigationService: INavigationService,
) : BaseViewModel<HomeScreenArguments>() {

    private var dataJob: Job? = null
    private val searchFlow = MutableStateFlow("")

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Empty())
        private set

    override fun onResume() {
        super.onResume()
        clearDataJob()
        dataJob = repositoryService.getCheckLists().combine(searchFlow) { data, searchText ->
            updateState(data, searchText)
        }.launchIn(viewModelScope)
    }

    override fun onPause() {
        super.onPause()
        clearDataJob()
    }

    fun onSearchTextChanged(text: String) {
        searchFlow.value = text
    }

    fun onCancelClick() {
        searchFlow.value = ""
    }

    fun onAddClick() {
        navigationService.navigateTo(Destination.Screen.CheckList(CheckListScreenArguments()))
    }

    fun onCardClick(id: Int) {
        navigationService.navigateTo(Destination.Screen.CheckList(CheckListScreenArguments(id)))
    }

    private fun clearDataJob() {
        dataJob?.cancel()
        dataJob = null
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
}
