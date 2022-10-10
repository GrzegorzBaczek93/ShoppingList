package com.grzegorz.baczek.shoppinglist.ui.screen.list.compose

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.Screen
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListViewModel
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.pop
import org.koin.androidx.compose.getViewModel

@Composable
fun ListScreen(navController: NavController<Screen>, listArguments: ListArguments) {
    val viewModel = getViewModel<ListViewModel>()
    viewModel.setArguments(listArguments)
    ListContent(onButtonClick = { navController.pop() })
}

@Composable
private fun ListContent(
    onButtonClick: () -> Unit,
) {
    TextButton(onClick = onButtonClick) {
        Text(text = "Go back")
    }
}