package com.grzegorz.baczek.shoppinglist.navigation.destination

import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogArguments

object DestinationHelper {
    fun getRemoveCheckListPopupDestination(
        onConfirmClick: () -> Unit,
        onDismissClick: () -> Unit,
    ) = Destination.Dialog.DoubleButton(
        DoubleButtonDialogArguments(
            title = R.string.remove_checklist_title_label,
            text = R.string.remove_checklist_text_label,
            confirmButtonText = R.string.yes_label,
            dismissButtonText = R.string.no_label,
            onConfirmClick = onConfirmClick,
            onDismissClick = onDismissClick,
        ),
    )
}