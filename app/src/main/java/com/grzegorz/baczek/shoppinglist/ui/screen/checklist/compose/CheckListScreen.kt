package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.AppBarMenuItem
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBar
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListScreenState
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import com.grzegorz.baczek.shoppinglist.utils.collection.addAll
import org.koin.androidx.compose.getViewModel

@Composable
fun CheckListScreen(arguments: CheckListArguments) {
    val viewModel = getViewModel<CheckListViewModel>()
    viewModel.setArguments(arguments)

    CheckListScreen(
        viewState = viewModel.viewState,
        checkList = viewModel.checkList,
        onBackButtonClick = viewModel::onBackButtonClick,
        onSwitchModeClick = viewModel::onSwitchModeClick,
        onRenewClick = viewModel::onRenewClick,
        onShareButtonClick = viewModel::onShareButtonClick,
        onRemoveButtonClick = viewModel::onRemoveButtonClick,
    )
}

@Composable
private fun CheckListScreen(
    viewState: CheckListScreenState,
    checkList: CheckList,
    onBackButtonClick: () -> Unit,
    onSwitchModeClick: () -> Unit,
    onRenewClick: () -> Unit,
    onShareButtonClick: () -> Unit,
    onRemoveButtonClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(
            title = checkList.title,
            startButton = AppBarMenuItem(
                text = stringResource(id = R.string.back_label),
                drawable = R.drawable.ic_arrow_back,
                onClick = onBackButtonClick,
            ),
            endButtons = buildList {
                when (viewState) {
                    is CheckListScreenState.Edit -> {
                        add(
                            AppBarMenuItem(
                                text = stringResource(R.string.save_label),
                                drawable = R.drawable.ic_save,
                                onClick = onSwitchModeClick,
                            ),
                        )
                    }
                    is CheckListScreenState.Preview -> {
                        addAll(
                            AppBarMenuItem(
                                text = stringResource(R.string.preview_label),
                                drawable = R.drawable.ic_edit_note,
                                onClick = onSwitchModeClick,
                            ),
                            AppBarMenuItem(
                                text = stringResource(R.string.renew_label),
                                drawable = R.drawable.ic_renew,
                                onClick = onRenewClick,
                            ),
                        )
                    }
                    else -> {}
                }
                addAll(
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
                )
            },
        )
        when (viewState) {
            CheckListScreenState.Edit -> CheckListEditContent()
            CheckListScreenState.Preview -> CheckListPreviewContent()
            CheckListScreenState.Loading -> {}
        }
    }
}
