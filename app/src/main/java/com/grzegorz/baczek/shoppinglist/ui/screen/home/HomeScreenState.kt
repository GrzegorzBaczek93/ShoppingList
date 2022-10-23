package com.grzegorz.baczek.shoppinglist.ui.screen.home

import com.grzegorz.baczek.shoppinglist.model.CheckList

sealed class HomeScreenState {

    object Empty : HomeScreenState()

    object NotFound : HomeScreenState()

    data class Content(
        val data: List<CheckList>,
    ) : HomeScreenState()
}
