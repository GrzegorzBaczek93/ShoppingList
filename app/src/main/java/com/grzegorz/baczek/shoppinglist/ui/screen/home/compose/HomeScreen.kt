package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeViewModel
import dev.olshevski.navigation.reimagined.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavController<Screen>, arguments: HomeArguments) {
    val viewModel = getViewModel<HomeViewModel>()
    viewModel.setArguments(arguments)
    viewModel.state.BuildUI()
}
