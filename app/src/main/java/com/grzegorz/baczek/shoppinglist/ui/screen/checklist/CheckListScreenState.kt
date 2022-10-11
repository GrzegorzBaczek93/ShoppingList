package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

sealed class CheckListScreenState {
    @Composable
    abstract fun BuildUI()

    object Loading : CheckListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "CheckList loading...")
        }
    }

    object Content : CheckListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "CheckList content.")
        }
    }

    object Error : CheckListScreenState() {
        @Composable
        override fun BuildUI() {
            Text(text = "CheckList error!")
        }
    }
}
