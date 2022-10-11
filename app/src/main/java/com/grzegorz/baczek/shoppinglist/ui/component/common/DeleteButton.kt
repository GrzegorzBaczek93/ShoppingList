package com.grzegorz.baczek.shoppinglist.ui.component.common

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.utils.compose.noRippleClickable

private val contentDescription = object {
    val icon = "Delete button"
}

@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier.noRippleClickable {
            onClick()
        },
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
        contentDescription = contentDescription.icon,
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error)
    )
}