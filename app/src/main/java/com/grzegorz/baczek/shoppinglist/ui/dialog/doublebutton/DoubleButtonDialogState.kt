package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton

sealed class DoubleButtonDialogState {
    object Empty : DoubleButtonDialogState()

    data class Content(
        val title: String,
        val text: String,
        val confirmButtonText: String,
        val dismissButtonText: String,
        val onConfirmClick: () -> Unit,
        val onDismissClick: () -> Unit,
    ) : DoubleButtonDialogState()
}
