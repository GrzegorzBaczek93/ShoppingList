package com.grzegorz.baczek.shoppinglist.ui.component.home

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.utils.compose.CustomTextField

private val dimens = object {
    val height = 56.dp
    val iconSize = 24.dp
    val iconPadding = (height - iconSize) / 2
    val textPadding = height - iconPadding
}

private val contentDescription = object {
    val leadingIcon = "Search icon"
    val trailingIcon = "Remove search text icon"
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCancelClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.height)
            .background(
                shape = CircleShape, color = MaterialTheme.colorScheme.primaryContainer,
            ),
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = dimens.iconPadding)
                .size(dimens.iconSize),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = contentDescription.leadingIcon,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer),
        )
        CustomTextField(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = dimens.textPadding),
            value = text,
            onValueChange = onTextChanged,
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_placeholder),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    localFocusManager.clearFocus(true)
                }
            ),
        )
        if (text.isNotBlank()) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = dimens.iconPadding)
                    .size(dimens.iconSize)
                    .clickable { onCancelClick() },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                contentDescription = contentDescription.trailingIcon,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer),
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
