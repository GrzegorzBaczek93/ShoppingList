package com.grzegorz.baczek.shoppinglist.ui.component.common.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.AppBarMenuItem

private val dimens = object {
    val height = 64.dp
    val horizontalPadding = 4.dp
    val startContainerMinWidth = 12.dp
}

private val consts = object {
    val maxSingleItems = 2
}

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    startButton: AppBarMenuItem = AppBarMenuItem.none,
    endButtons: List<AppBarMenuItem> = emptyList(),
) {
    ConstraintLayout(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .height(dimens.height)
            .padding(horizontal = dimens.horizontalPadding),
    ) {
        val (startContainerRef, endContainerRef, titleContainer) = createRefs()
        Box(
            modifier = Modifier
                .defaultMinSize(minWidth = dimens.startContainerMinWidth)
                .constrainAs(startContainerRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
        ) {
            StartContainer(startButton)
        }
        Text(
            modifier = Modifier.constrainAs(titleContainer) {
                start.linkTo(startContainerRef.end)
                end.linkTo(endContainerRef.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            },
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Row(
            modifier = Modifier.constrainAs(endContainerRef) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
        ) {
            EndContainer(endButtons)
        }
    }
}

@Composable
private fun StartContainer(startButton: AppBarMenuItem) {
    if (startButton != AppBarMenuItem.none) {
        AppBarImageButton(onClick = startButton.onClick, imageDrawable = startButton.drawable)
    }
}

@Composable
private fun EndContainer(endButtons: List<AppBarMenuItem>) {
    if (endButtons.size > consts.maxSingleItems) {
        AppBarImageButton(onClick = endButtons.first().onClick, imageDrawable = endButtons.first().drawable)
        AppBarDropdownMenu(items = endButtons.drop(1))
    } else {
        endButtons.forEach {
            AppBarImageButton(onClick = it.onClick, imageDrawable = it.drawable)
        }
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    AppBar(
        title = "Very long title with even longer text",
        startButton = AppBarMenuItem(
            text = stringResource(id = R.string.back_label),
            drawable = R.drawable.ic_arrow_back,
            onClick = {},
        ),
    )
}
