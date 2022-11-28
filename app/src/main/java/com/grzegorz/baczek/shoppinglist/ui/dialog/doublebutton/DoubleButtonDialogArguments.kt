package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton

import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments

data class DoubleButtonDialogArguments(
    val title: String,
    val text: String,
    val confirmButtonText: String,
    val dismissButtonText: String,
    val onConfirmClick: () -> Unit,
    val onDismissClick: () -> Unit,
) : BaseArguments
