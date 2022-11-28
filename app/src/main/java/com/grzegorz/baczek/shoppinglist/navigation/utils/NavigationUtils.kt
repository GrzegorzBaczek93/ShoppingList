package com.grzegorz.baczek.shoppinglist.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

@Composable
fun <A : BaseArguments, V : BaseViewModel<A>> bind(viewModel: V, arguments: A) {

    LaunchedEffect(arguments) {
        viewModel.setArguments(arguments)
    }
    LaunchedEffect(Unit) {
        viewModel.onResume()
    }
    DisposableEffect(Unit) {
        onDispose {
            viewModel.onPause()
        }
    }
}
