package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.AppBarMenuItem
import com.grzegorz.baczek.shoppinglist.navigation.utils.bind
import com.grzegorz.baczek.shoppinglist.ui.component.common.appbar.AppBar
import com.grzegorz.baczek.shoppinglist.ui.component.home.SearchBar
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenState
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenViewModel
import org.koin.androidx.compose.getViewModel

private val dimens = object {
    val contentPadding = 16.dp
}

@Composable
fun HomeScreen(arguments: HomeScreenArguments) {
    val viewModel = getViewModel<HomeScreenViewModel>()
    bind(viewModel = viewModel, arguments = arguments)

    HomeScreen(
        state = viewModel.state,
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
    onSearchTextChanged: (String) -> Unit,
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit,
    onCardClick: (Int) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(null) {
                detectTapGestures(
                    onTap = {
                        keyboardController?.hide()
                        localFocusManager.clearFocus(true)
                    }
                )
            },
    ) {
        AppBar(
            endButtons = listOf(
                AppBarMenuItem(
                    text = stringResource(id = R.string.add_label),
                    drawable = R.drawable.ic_add,
                    onClick = onAddClick,
                ),
            ),
        )
        Column(
            modifier = Modifier
                .padding(top = dimens.contentPadding)
                .padding(horizontal = dimens.contentPadding),
        ) {
            SearchBar(text = state.searchText, onTextChanged = onSearchTextChanged, onCancelClick = onCancelClick)
            when (state) {
                is HomeScreenState.Content -> HomeScreenContent(data = state.data, onCardClick = onCardClick)
                is HomeScreenState.Empty -> HomeScreenEmpty()
                is HomeScreenState.NotFound -> HomeScreenNotFound()
            }
        }
    }
}
