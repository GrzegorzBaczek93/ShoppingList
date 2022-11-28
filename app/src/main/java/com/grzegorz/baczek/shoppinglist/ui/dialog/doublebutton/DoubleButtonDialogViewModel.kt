package com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class DoubleButtonDialogViewModel : BaseViewModel<DoubleButtonDialogArguments>() {

    var state by mutableStateOf<DoubleButtonDialogState>(DoubleButtonDialogState.Empty)

    override fun onArgumentsObtained(args: DoubleButtonDialogArguments) {
        super.onArgumentsObtained(args)
        state = with(args) {
            DoubleButtonDialogState.Content(
                title,
                text,
                confirmButtonText,
                dismissButtonText,
                onConfirmClick,
                onDismissClick,
            )
        }
    }
}
