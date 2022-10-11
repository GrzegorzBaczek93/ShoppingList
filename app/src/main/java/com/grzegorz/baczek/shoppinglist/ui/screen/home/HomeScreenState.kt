package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.ui.screen.home.compose.HomeContent

sealed class HomeScreenState {
    @Composable
    abstract fun BuildUI(
        data: List<CheckList>,
        searchText: String,
        onSearchTextChanged: (String) -> Unit,
        onCancelClick: () -> Unit,
    )

    object Loading : HomeScreenState() {
        @Composable
        override fun BuildUI(
            data: List<CheckList>,
            searchText: String,
            onSearchTextChanged: (String) -> Unit,
            onCancelClick: () -> Unit,
        ) {
        }
    }

    object Content : HomeScreenState() {
        @Composable
        override fun BuildUI(
            data: List<CheckList>,
            searchText: String,
            onSearchTextChanged: (String) -> Unit,
            onCancelClick: () -> Unit,
        ) {
            HomeContent(
                data = data,
                searchText = searchText,
                onSearchTextChanged = onSearchTextChanged,
                onCancelClick = onCancelClick)
        }
    }

    object Error : HomeScreenState() {
        @Composable
        override fun BuildUI(
            data: List<CheckList>,
            searchText: String,
            onSearchTextChanged: (String) -> Unit,
            onCancelClick: () -> Unit,
        ) {
        }
    }
}
