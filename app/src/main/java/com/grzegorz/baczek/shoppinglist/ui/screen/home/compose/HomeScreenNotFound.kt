package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R

private val dimens = object {
    val textPaddingTop = 168.dp
}

@Composable
fun HomeScreenNotFound() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Text(
            modifier = Modifier.padding(top = dimens.textPaddingTop),
            text = stringResource(id = R.string.home_not_found_label),
            style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
        )
    }
}
