package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

sealed class CheckListScreenState {

    object Loading : CheckListScreenState()
    object Preview : CheckListScreenState()
    object Edit : CheckListScreenState()
}
