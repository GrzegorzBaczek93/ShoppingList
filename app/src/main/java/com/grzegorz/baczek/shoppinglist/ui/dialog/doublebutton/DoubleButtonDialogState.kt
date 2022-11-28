package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton

import androidx.annotation.StringRes

sealed class DoubleButtonDialogState {
    object Empty : DoubleButtonDialogState()

    data class Content(
        @StringRes val title: Int,
        @StringRes val text: Int,
        @StringRes val confirmButtonText: Int,
        @StringRes val dismissButtonText: Int,
        val onConfirmClick: () -> Unit,
        val onDismissClick: () -> Unit,
    ) : DoubleButtonDialogState()
}
