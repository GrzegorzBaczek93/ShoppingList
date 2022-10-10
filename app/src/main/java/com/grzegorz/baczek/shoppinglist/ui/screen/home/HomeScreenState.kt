package com.grzegorz.baczek.shoppinglist.ui.screen.home

import com.grzegorz.baczek.shoppinglist.utils.base.BaseScreenState

sealed class HomeScreenState : BaseScreenState {
    object Loading : HomeScreenState()
    object Success : HomeScreenState()
    object Error : HomeScreenState()
}