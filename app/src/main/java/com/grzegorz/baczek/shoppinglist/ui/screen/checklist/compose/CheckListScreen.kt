package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBar
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBarDropdownMenu
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBarDropdownMenuItem
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBarImageButton
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
                AppBarImageButton(onClick = onBackButtonClick, imageDrawable = R.drawable.ic_arrow_back)
            },
            endContainer = {
                when (viewState) {
                    is CheckListScreenState.Edit -> AppBarImageButton(onClick = onSwitchModeClick,
                        imageDrawable = R.drawable.ic_save)
                    is CheckListScreenState.Preview -> AppBarImageButton(onClick = onSwitchModeClick,
                        imageDrawable = R.drawable.ic_edit_note)
                    else -> {}
                }
                AppBarDropdownMenu(
                    AppBarDropdownMenuItem(
                        text = stringResource(R.string.share_label),
                        drawable = R.drawable.ic_share,
                        onClick = onShareButtonClick,
                    ),
                    AppBarDropdownMenuItem(
                        text = stringResource(R.string.remove_label),
                        drawable = R.drawable.ic_remove,
                        onClick = onRemoveButtonClick,
                    ),
                )
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
