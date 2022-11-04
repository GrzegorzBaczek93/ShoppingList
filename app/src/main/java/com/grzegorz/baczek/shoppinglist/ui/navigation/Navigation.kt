package com.grzegorz.baczek.shoppinglist.ui.navigation

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import dev.olshevski.navigation.reimagined.DialogNavHost
import dev.olshevski.navigation.reimagined.NavHost
import org.koin.androidx.compose.getStateViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val viewModel = getStateViewModel<NavigationViewModel>(state = { Bundle.EMPTY })

    BackHandler(enabled = viewModel.backEnabled, onBack = viewModel::onBackPress)
    NavHost(backstack = viewModel.backStack) { screen -> screen.Content() }
    DialogNavHost(backstack = viewModel.dialogBackStack) { dialog -> dialog.Content() }
}
