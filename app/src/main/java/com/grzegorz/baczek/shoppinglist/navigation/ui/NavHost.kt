package com.grzegorz.baczek.shoppinglist.navigation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState

@Composable
fun NavHost(
    screenState: NavState,
    dialogState: NavState,
    backEnabled: Boolean,
    onBack: () -> Unit,
) {
    BackHandler(enabled = backEnabled, onBack = onBack)

    when (screenState) {
        is NavState.Entry -> {
            screenState.entry.let { screenNavEntry ->
                screenNavEntry.Component {
                    screenNavEntry.destination.Content()
                }
            }
        }
        else -> {}
    }
    when (dialogState) {
        is NavState.Entry -> {
            dialogState.entry.let { screenNavEntry ->
                screenNavEntry.Component {
                    screenNavEntry.destination.Content()
                }
            }
        }
        else -> {}
    }
}
