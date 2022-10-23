package com.grzegorz.baczek.shoppinglist.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R

private val dimens = object {
    val height = 64.dp
    val horizontalPadding = 4.dp
}

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    startContainer: @Composable () -> Unit = {},
    endContainer: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .height(dimens.height)
            .padding(horizontal = dimens.horizontalPadding),
    ) {
        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            startContainer()
        }
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            endContainer()
        }
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    AppBar()
}
