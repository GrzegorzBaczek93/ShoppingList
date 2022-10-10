package com.grzegorz.baczek.shoppinglist.ui.screen.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

sealed class ListScreenState {
    @Composable
    abstract fun BuildUI()

    object Loading : ListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "List loading...")
        }
    }

    object Content : ListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "List content.")
        }
    }

    object Error : ListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "List error!")
        }
    }
}
