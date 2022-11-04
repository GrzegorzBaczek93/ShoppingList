package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.ui.component.home.Card

private val dimens = object {
    val itemsSpacer = 8.dp
    val listPaddingTop = 16.dp
}

@Composable
fun HomeScreenContent(data: List<CheckList>, onCardClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimens.itemsSpacer),
        contentPadding = PaddingValues(vertical = dimens.listPaddingTop),
    ) {
        items(data) { singleItem ->
            Card(item = singleItem, onClick = onCardClick)
        }
    }
}
