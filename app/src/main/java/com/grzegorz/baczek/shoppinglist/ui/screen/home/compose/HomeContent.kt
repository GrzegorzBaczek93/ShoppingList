package com.grzegorz.baczek.shoppinglist.ui.screen.home.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.ui.component.home.Card
import com.grzegorz.baczek.shoppinglist.ui.component.home.SearchBar

private object HomeContentDimens {
    val contentPadding = 16.dp
    val itemsSpacer = 8.dp
    val listPaddingTop = 16.dp
}

@Composable
fun HomeContent(
    data: List<CheckList>,
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onCancelClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = HomeContentDimens.contentPadding)
            .padding(horizontal = HomeContentDimens.contentPadding),
    ) {
        SearchBar(text = searchText, onTextChanged = onSearchTextChanged, onCancelClick = onCancelClick)
        LazyColumn(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(HomeContentDimens.itemsSpacer),
            contentPadding = PaddingValues(vertical = HomeContentDimens.listPaddingTop),
        ) {
            items(data) { singleItem ->
                Card(item = singleItem)
            }
        }
    }
}