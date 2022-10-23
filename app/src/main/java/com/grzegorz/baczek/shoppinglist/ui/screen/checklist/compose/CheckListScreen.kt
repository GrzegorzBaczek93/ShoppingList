package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBar
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppBarButton
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CheckListScreen(arguments: CheckListArguments) {
    val viewModel = getViewModel<CheckListViewModel>()
    viewModel.setArguments(arguments)

    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(
            startContainer = {
                AppBarButton(onClick = viewModel::onBackButtonClick, imageDrawable = R.drawable.ic_arrow_back)
            },
            endContainer = {
                AppBarButton(onClick = viewModel::onShareButtonClick, imageDrawable = R.drawable.ic_share)
                AppBarButton(onClick = viewModel::onRemoveButtonClick, imageDrawable = R.drawable.ic_delete)
            }
        )
    }
}
