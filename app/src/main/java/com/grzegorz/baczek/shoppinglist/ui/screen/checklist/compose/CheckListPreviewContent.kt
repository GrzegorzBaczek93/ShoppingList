package com.grzegorz.baczek.shoppinglist.ui.screen.checklist.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.grzegorz.baczek.shoppinglist.R
import com.grzegorz.baczek.shoppinglist.model.CheckListItem
import com.grzegorz.baczek.shoppinglist.utils.compose.noRippleClickable

private val dimens = object {
    val iconSize = 24.dp
}

private val contentDescription = object {
    val button = "Button"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckListPreviewContent(
    items: List<CheckListItem>,
    onClicked: (Int) -> Unit,
) {
    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items.forEach { singleItem ->
            val (id, text, checked) = singleItem
            ListItem(
                headlineText = {
                    Text(text = text)
                },
                trailingContent = {
                    Image(
                        modifier = Modifier
                            .noRippleClickable { onClicked(id) }
                            .size(dimens.iconSize),
                        imageVector = ImageVector.vectorResource(
                            id = if (checked) R.drawable.ic_check_box else R.drawable.ic_check_box_blank,
                        ),
                        contentDescription = contentDescription.button,
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface),
                    )
                },
            )
        }
    }
}
