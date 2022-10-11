package com.grzegorz.baczek.shoppinglist.ui.screen.list.compose

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ListScreen(arguments: ListArguments) {
    val viewModel = getViewModel<ListViewModel>()
    viewModel.setArguments(arguments)
    viewModel.state.BuildUI()
}
