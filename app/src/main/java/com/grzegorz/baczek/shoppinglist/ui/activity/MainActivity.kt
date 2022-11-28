package com.grzegorz.baczek.shoppinglist.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppContainer
import com.grzegorz.baczek.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                AppContainer {

                }
            }
        }
    }
}
