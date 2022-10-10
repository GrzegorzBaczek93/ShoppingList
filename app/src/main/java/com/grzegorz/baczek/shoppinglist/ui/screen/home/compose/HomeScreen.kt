package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenState
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navigate
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavController<Screen>, arguments: HomeArguments) {
    val viewModel = getViewModel<HomeViewModel>()
    viewModel.setArguments(arguments)
    HomeContent(viewModel.state, onButtonClick = { navController.navigate(Screen.List(ListArguments(0))) })
}

@Composable
private fun HomeContent(
    state: HomeScreenState,
    onButtonClick: () -> Unit,
) {
    Text(text = state.toString())
    TextButton(onClick = onButtonClick) {
        Text(text = "Go to List")
    }
}

