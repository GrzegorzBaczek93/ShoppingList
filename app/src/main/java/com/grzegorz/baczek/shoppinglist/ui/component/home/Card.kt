package com.grzegorz.baczek.shoppinglist.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.model.CheckListItem
import com.grzegorz.baczek.shoppinglist.ui.theme.replyLightPrimaryContainer

private const val MAX_ITEMS = 3

private val dimens = object {
    val cardPadding = 2.dp
    val elevation = 2.dp
    val contentPadding = 12.dp
}

@Composable
fun Card(
    modifier: Modifier = Modifier,
    item: CheckList,
) {
    Surface(
        modifier = modifier
            .padding(dimens.cardPadding)
            .wrapContentHeight()
            .fillMaxWidth(),
        shadowElevation = dimens.elevation,
        shape = MaterialTheme.shapes.medium,
        contentColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        Column(
            modifier = Modifier.padding(dimens.contentPadding),
        ) {
            Title(text = item.title)
            item.items.take(MAX_ITEMS).forEach { SingleItem(text = it.text) }
        }
    }
}

@Composable
private fun Title(text: String) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
    )
}

@Composable
private fun SingleItem(text: String) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        fontSize = 12.sp,
    )
}

@Preview(locale = "en")
@Composable
private fun CardPreviewWithItems() {
    Box(modifier = Modifier
        .wrapContentSize()
        .background(replyLightPrimaryContainer)
        .padding(16.dp)) {
        Card(item = CheckList(
            id = "0",
            title = "Jabłecznik",
            items = listOf(
                CheckListItem("Jabłka"),
                CheckListItem("Jabłka"),
                CheckListItem("Jabłka"),
                CheckListItem("Jabłka"),
            ),
        ))
    }
}

@Preview(locale = "pl")
@Composable
private fun CardPreviewWithoutItems() {
    Box(modifier = Modifier
        .wrapContentSize()
        .background(replyLightPrimaryContainer)
        .padding(16.dp)) {
        Card(item = CheckList(
            id = "0",
            title = "Jabłecznik",
            items = emptyList(),
        ))
    }
}
