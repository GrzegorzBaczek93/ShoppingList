package com.grzegorz.baczek.shoppinglist.ui.screen.home

import com.grzegorz.baczek.shoppinglist.model.CheckList

sealed class HomeScreenState(
    open val searchText: String,
) {
    data class Loading(
        override val searchText: String = "",
    ) : HomeScreenState(searchText)

    data class Empty(
        override val searchText: String = "",
    ) : HomeScreenState(searchText)

    data class NotFound(
        override val searchText: String = "",
    ) : HomeScreenState(searchText)

    data class Content(
        override val searchText: String = "",
        val data: List<CheckList>,
    ) : HomeScreenState(searchText)
}
