package com.grzegorz.baczek.shoppinglist.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.grzegorz.baczek.shoppinglist.navigation.ui.NavHost
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppContainer
import com.grzegorz.baczek.shoppinglist.ui.theme.ShoppingListTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                AppContainer {
                    Navigation()
                }
            }
        }
    }

    @Composable
    private fun Navigation() {
        NavHost(
            state = viewModel.state,
            backEnabled = viewModel.isBackEnabled,
            onBack = viewModel::goBack,
        )
    }
}
