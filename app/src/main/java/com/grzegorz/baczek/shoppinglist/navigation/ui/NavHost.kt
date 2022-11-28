package com.grzegorz.baczek.shoppinglist.navigation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import com.grzegorz.baczek.shoppinglist.utils.compose.Todo

@Composable
fun NavHost(
    state: NavState,
    backEnabled: Boolean,
    onBack: () -> Unit,
) {
    BackHandler(enabled = backEnabled, onBack = onBack)

    when (state) {
        NavState.Empty -> {
            Todo("Nav state empty")
        }
        is NavState.Entry -> {
            state.screenNavEntry?.let { screenNavEntry ->
                screenNavEntry.Component {
                    screenNavEntry.destination.Content()
                }
            }
            state.dialogNavEntry?.let { dialogNavEntry ->
                dialogNavEntry.Component {
                    dialogNavEntry.destination.Content()
                }
            }
        }
    }
}
