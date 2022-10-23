package com.grzegorz.baczek.shoppinglist.utils.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Todo(text: String = "Todo") {
    Text(text = text)
}