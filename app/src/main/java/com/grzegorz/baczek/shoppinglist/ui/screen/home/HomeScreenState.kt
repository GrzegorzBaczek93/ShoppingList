package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

sealed class HomeScreenState {
    @Composable
    abstract fun BuildUI()

    object Loading : HomeScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "Home loading...")
        }
    }

    object Content : HomeScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "Home content.")
        }
    }

    object Error : HomeScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "Home error!")
        }
    }
}