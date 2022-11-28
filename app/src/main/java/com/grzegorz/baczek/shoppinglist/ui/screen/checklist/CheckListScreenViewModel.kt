package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.model.cleared
import com.grzegorz.baczek.shoppinglist.model.toggled
import com.grzegorz.baczek.shoppinglist.navigation.service.INavigationService
import com.grzegorz.baczek.shoppinglist.service.storage.IRepositoryService
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class CheckListScreenViewModel(
    private val repositoryService: IRepositoryService,
    private val navigationService: INavigationService,
) : BaseViewModel<CheckListScreenArguments>() {

    var viewState by mutableStateOf<CheckListScreenState>(CheckListScreenState.Preview)
        private set

    var checkList by mutableStateOf(CheckList.empty)

    override fun onArgumentsObtained(args: CheckListScreenArguments) {
        super.onArgumentsObtained(args)
        args.id?.let { getCheckList(it) } ?: setEditMode()
    }

    fun onBackButtonClick() {
        navigationService.pop()
    }

    fun onSwitchModeClick() {
        when (viewState) {
            CheckListScreenState.Edit -> setPreviewMode()
            CheckListScreenState.Preview -> setEditMode()
            else -> {}
        }
    }

    fun onPreviewItemClick(id: Int) {
        checkList = checkList.toggled(id)
    }

    fun onRenewClick() {
        checkList = checkList.cleared()
    }

    fun onShareButtonClick() {
    }

    fun onRemoveButtonClick() {
    }

    private fun getCheckList(id: Int) {
        checkList = repositoryService.getCheckList(id)
        setPreviewMode()
    }

    private fun setEditMode() {
        viewState = CheckListScreenState.Edit
    }

    private fun setPreviewMode() {
        viewState = CheckListScreenState.Preview
    }
}