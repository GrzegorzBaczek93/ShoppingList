package com.grzegorz.baczek.shoppinglist.ui.navigation

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import dev.olshevski.navigation.reimagined.NavHost
import org.koin.androidx.compose.getStateViewModel

@Composable
fun Navigation() {
    val viewModel = getStateViewModel<NavigationViewModel>(state = { Bundle.EMPTY })

    BackHandler(enabled = viewModel.backEnabled, onBack = viewModel::onBackPress)
    NavHost(backstack = viewModel.backStack) { screen -> screen.Content() }
}
