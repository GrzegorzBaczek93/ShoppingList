package com.grzegorz.baczek.shoppinglist.ui.component.common.appbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.AppBarMenuItem

private val dimens = object {
    val iconBoxSize = 48.dp
    val iconSize = 24.dp
    val menuMinWidth = 160.dp
    val menuMaxWidth = 280.dp
    val menuPaddingStart = 12.dp
    val menuPaddingTop = 0.dp
}

private val contentDescription = object {
    val button = "Button"
}

@Composable
fun AppBarDropdownMenu(
    items: List<AppBarMenuItem>,
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopEnd)) {
        Box(
            modifier = Modifier
                .size(dimens.iconBoxSize)
                .clickable { expanded = expanded.not() },
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.size(dimens.iconSize),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_more),
                contentDescription = contentDescription.button,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            )
        }
        DropdownMenu(
            modifier = Modifier.widthIn(dimens.menuMinWidth, dimens.menuMaxWidth),
            expanded = expanded,
            offset = DpOffset(dimens.menuPaddingStart, dimens.menuPaddingTop),
            onDismissRequest = { expanded = false },
        ) {
            items.forEach { (text, drawable, onClick) ->
                AppBarDropdownMenuElement(text, drawable) {
                    onClick()
                    expanded = false
                }
            }
        }
    }
}

@Composable
private fun AppBarDropdownMenuElement(text: String, drawable: Int, onClick: () -> Unit) {
    DropdownMenuItem(
        text = {
            Text(text = text)
        },
        leadingIcon = {
            Image(
                modifier = Modifier.size(dimens.iconSize),
                imageVector = ImageVector.vectorResource(id = drawable),
                contentDescription = contentDescription.button,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
            )
        },
        enabled = true,
        onClick = onClick,
    )
}

