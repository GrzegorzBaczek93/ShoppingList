package com.grzegorz.baczek.shoppinglist.ui.screen.list.compose

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListViewModel
import dev.olshevski.navigation.reimagined.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun ListScreen(navController: NavController<Screen>, arguments: ListArguments) {
    val viewModel = getViewModel<ListViewModel>()
    viewModel.setArguments(arguments)
    viewModel.state.BuildUI()
}