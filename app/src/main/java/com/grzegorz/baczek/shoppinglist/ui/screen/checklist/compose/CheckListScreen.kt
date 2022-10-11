package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CheckListScreen(arguments: CheckListArguments) {
    val viewModel = getViewModel<CheckListViewModel>()
    viewModel.setArguments(arguments)
    viewModel.state.BuildUI()
}
