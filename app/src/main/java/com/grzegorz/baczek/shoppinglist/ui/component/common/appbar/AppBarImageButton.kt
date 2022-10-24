package com.grzegorz.baczek.shoppinglist.ui.component.common.appbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R

private val dimens = object {
    val iconBoxSize = 48.dp
    val iconSize = 24.dp
}

private val contentDescription = object {
    val button = "Button"
}

@Composable
fun AppBarImageButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes imageDrawable: Int,
) {
    Box(
        modifier = modifier
            .size(dimens.iconBoxSize)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(dimens.iconSize),
            imageVector = ImageVector.vectorResource(id = imageDrawable),
            contentDescription = contentDescription.button,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
        )
    }
}

@Preview
@Composable
private fun AppBarButtonPreview() {
    AppBarImageButton(
        onClick = {},
        imageDrawable = R.drawable.ic_arrow_back,
    )
}