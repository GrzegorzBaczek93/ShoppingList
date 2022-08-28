package com.grzegorz.baczek.shoppinglist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.secondary
            )
    ) {

    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar()
}