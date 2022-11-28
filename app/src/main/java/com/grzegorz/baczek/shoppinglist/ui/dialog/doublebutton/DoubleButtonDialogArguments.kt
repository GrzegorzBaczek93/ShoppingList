package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton

import androidx.annotation.StringRes
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments

data class DoubleButtonDialogArguments(
    @StringRes val title: Int,
    @StringRes val text: Int,
    @StringRes val confirmButtonText: Int,
    @StringRes val dismissButtonText: Int,
    val onConfirmClick: () -> Unit,
    val onDismissClick: () -> Unit,
) : BaseArguments
