package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.compose

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.grzegorz.baczek.shoppinglist.navigation.utils.bind
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogArguments
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogState
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DoubleButtonDialog(
    arguments: DoubleButtonDialogArguments,
) {
    val viewModel = getViewModel<DoubleButtonDialogViewModel>()
    bind(viewModel = viewModel, arguments = arguments)

    when (val state = viewModel.state) {
        is DoubleButtonDialogState.Content -> DoubleButtonDialog(state)
        DoubleButtonDialogState.Empty -> {}
    }
}

@Composable
private fun DoubleButtonDialog(
    state: DoubleButtonDialogState.Content,
) {
    AlertDialog(
        onDismissRequest = state.onDismissClick,
        confirmButton = {
            TextButton(onClick = state.onConfirmClick) {
                Text(text = stringResource(id = state.confirmButtonText))
            }
        },
        dismissButton = {
            TextButton(onClick = state.onDismissClick) {
                Text(text = stringResource(id = state.dismissButtonText))
            }
        },
        title = {
            Text(text = stringResource(id = state.title))
        },
        text = {
            Text(text = stringResource(id = state.text))
        },
    )
}
