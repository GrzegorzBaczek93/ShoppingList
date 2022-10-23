package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBar
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBarButton
import com.grzegorz.baczek.shoppinglist.ui.component.home.Card
import com.grzegorz.baczek.shoppinglist.ui.component.home.SearchBar
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenState
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeViewModel
import com.grzegorz.baczek.shoppinglist.utils.compose.Todo
import org.koin.androidx.compose.getViewModel

private val dimens = object {
    val contentPadding = 16.dp
    val itemsSpacer = 8.dp
    val listPaddingTop = 16.dp
}

@Composable
fun HomeScreen(arguments: HomeArguments) {
    val viewModel = getViewModel<HomeViewModel>()
    viewModel.setArguments(arguments)

    HomeScreen(
        state = viewModel.state,
        searchText = viewModel.searchText,
        onSearchTextChanged = viewModel::onSearchTextChanged,
        onAddClick = viewModel::onAddClick,
        onCancelClick = viewModel::onCancelClick,
        onCardClick = viewModel::onCardClick,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun HomeScreen(
    state: HomeScreenState,
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit,
    onCardClick: (String) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(null) {
                detectTapGestures(onTap = {
                    keyboardController?.hide()
                    localFocusManager.clearFocus(true)
                })
            },
    ) {
        AppBar(
            endContainer = {
                AppBarButton(onClick = onAddClick, imageDrawable = R.drawable.ic_add)
            },
        )
        Column(
            modifier = Modifier
                .padding(top = dimens.contentPadding)
                .padding(horizontal = dimens.contentPadding),
        ) {
            SearchBar(text = searchText, onTextChanged = onSearchTextChanged, onCancelClick = onCancelClick)
            when (state) {
                is HomeScreenState.Content -> HomeScreenContent(data = state.data, onCardClick = onCardClick)
                HomeScreenState.Empty -> HomeScreenEmpty()
                HomeScreenState.NotFound -> HomeScreenNotFound()
            }
        }
    }
}

@Composable
private fun HomeScreenContent(data: List<CheckList>, onCardClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimens.itemsSpacer),
        contentPadding = PaddingValues(vertical = dimens.listPaddingTop),
    ) {
        items(data) { singleItem ->
            Card(item = singleItem, onClick = onCardClick)
        }
    }
}

@Composable
private fun HomeScreenEmpty() {
    Todo()
}

@Composable
private fun HomeScreenNotFound() {
    Todo()
}
