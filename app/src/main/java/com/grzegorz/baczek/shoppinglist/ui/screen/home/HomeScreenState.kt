package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

sealed class HomeScreenState {
    @Composable
    abstract fun BuildUI(
        onButtonClick: () -> Unit,
    )

    object Loading : HomeScreenState() {
        @Composable
        override fun BuildUI(
            onButtonClick: () -> Unit,
        ) {
            Text(text = "Home loading...")
        }
    }

    object Content : HomeScreenState() {
        @Composable
        override fun BuildUI(
            onButtonClick: () -> Unit,
        ) {
            Text(text = "Home content.")
            TextButton(onClick = onButtonClick) {
                Text("Go to List screen")
            }
        }
    }

    object Error : HomeScreenState() {
        @Composable
        override fun BuildUI(
            onButtonClick: () -> Unit,
        ) {
            Text(text = "Home error!")
        }
    }
}
