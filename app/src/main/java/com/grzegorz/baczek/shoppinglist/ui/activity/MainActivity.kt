package com.grzegorz.baczek.shoppinglist.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.grzegorz.baczek.shoppinglist.ui.component.common.AppContainer
import com.grzegorz.baczek.shoppinglist.ui.navigation.Navigation
import com.grzegorz.baczek.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
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
}
