package com.grzegorz.baczek.shoppinglist.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.utils.compose.CustomTextField

private object SearchBarDimens {
    val height = 56.dp
    val iconSize = 24.dp
    val iconPadding = (height - iconSize) / 2
    val textPadding = height - iconPadding
}

private object SearchBarContentDescription {
    const val leadingIcon = "Search icon"
    const val trailingIcon = "Remove search text icon"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCancelClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(SearchBarDimens.height)
            .background(
                shape = CircleShape, color = MaterialTheme.colorScheme.primaryContainer,
            ),
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = SearchBarDimens.iconPadding)
                .size(SearchBarDimens.iconSize),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = SearchBarContentDescription.leadingIcon,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
        )
        CustomTextField(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = SearchBarDimens.textPadding),
            value = text,
            onValueChange = onTextChanged,
            textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_placeholder),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Start,
                    ),
                )
            },
        )
        if (text.isNotBlank()) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = SearchBarDimens.iconPadding)
                    .size(SearchBarDimens.iconSize)
                    .clickable { onCancelClick() },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                contentDescription = SearchBarContentDescription.trailingIcon,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
            )
        }
    }
}

@Preview(locale = "en")
@Composable
private fun SearchBarPreviewEn() {
    SearchBar("", {}) {}
}

@Preview(locale = "pl")
@Composable
private fun SearchBarPreviewPl() {
    SearchBar("", {}) {}
}

@Preview(locale = "en")
@Composable
private fun SearchBarPreviewEnWithText() {
    SearchBar("Pancakes", {}) {}
}

@Preview(locale = "pl")
@Composable
private fun SearchBarPreviewPlWithText() {
    SearchBar("Naleśniki", {}) {}
}
