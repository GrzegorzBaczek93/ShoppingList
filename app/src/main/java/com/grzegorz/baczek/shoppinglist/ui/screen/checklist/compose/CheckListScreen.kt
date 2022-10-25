package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.AppBarMenuItem
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBar
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
            startButton = AppBarMenuItem(
                text = stringResource(id = R.string.back_label),
                drawable = R.drawable.ic_arrow_back,
                onClick = onBackButtonClick,
            ),
            endButtons = listOfNotNull(
                when (viewState) {
                    is CheckListScreenState.Edit -> AppBarMenuItem(
                        text = stringResource(R.string.save_label),
                        drawable = R.drawable.ic_save,
                        onClick = onSwitchModeClick,
                    )
                    is CheckListScreenState.Preview -> AppBarMenuItem(
                        text = stringResource(R.string.preview_label),
                        drawable = R.drawable.ic_edit_note,
                        onClick = onSwitchModeClick,
                    )
                    else -> null
                },
                AppBarMenuItem(
                    text = stringResource(R.string.share_label),
                    drawable = R.drawable.ic_share,
                    onClick = onShareButtonClick,
                ),
                AppBarMenuItem(
                    text = stringResource(R.string.remove_label),
                    drawable = R.drawable.ic_remove,
                    onClick = onRemoveButtonClick,
                ),
            ),
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
