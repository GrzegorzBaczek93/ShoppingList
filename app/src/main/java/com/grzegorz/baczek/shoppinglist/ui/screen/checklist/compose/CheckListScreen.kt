package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBar
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBarButton
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListScreenState
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import com.grzegorz.baczek.shoppinglist.utils.compose.Todo
import org.koin.androidx.compose.getViewModel

@Composable
fun CheckListScreen(arguments: CheckListArguments) {
    val viewModel = getViewModel<CheckListViewModel>()
    viewModel.setArguments(arguments)

    CheckListScreen(
        viewState = viewModel.viewState,
        onBackButtonClick = viewModel::onBackButtonClick,
        onSwitchModeClick = viewModel::onSwitchModeClick,
        onShareButtonClick = viewModel::onShareButtonClick,
        onRemoveButtonClick = viewModel::onRemoveButtonClick,
    )
}

@Composable
private fun CheckListScreen(
    viewState: CheckListScreenState,
    onBackButtonClick: () -> Unit,
    onSwitchModeClick: () -> Unit,
    onShareButtonClick: () -> Unit,
    onRemoveButtonClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(
            title = "",
            startContainer = {
                AppBarButton(onClick = onBackButtonClick, imageDrawable = R.drawable.ic_arrow_back)
            },
            endContainer = {
                when (viewState) {
                    is CheckListScreenState.Edit -> AppBarButton(onClick = onSwitchModeClick,
                        imageDrawable = R.drawable.ic_save)
                    is CheckListScreenState.Preview -> AppBarButton(onClick = onSwitchModeClick,
                        imageDrawable = R.drawable.ic_edit_note)
                    else -> {}
                }
                AppBarButton(onClick = onShareButtonClick, imageDrawable = R.drawable.ic_share)
                AppBarButton(onClick = onRemoveButtonClick, imageDrawable = R.drawable.ic_delete)
            },
        )
        when (viewState) {
            CheckListScreenState.Edit -> CheckListEditContentScreen()
            CheckListScreenState.Preview -> CheckListPreviewContentScreen()
            CheckListScreenState.Loading -> {}
        }
    }
}

@Composable
private fun CheckListEditContentScreen() {
    Todo("CheckListEditContentScreen")
}

@Composable
private fun CheckListPreviewContentScreen() {
    Todo("CheckListPreviewContentScreen")
}
