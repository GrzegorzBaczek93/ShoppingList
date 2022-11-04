package com.grzegorz.baczek.shoppinglist.model

import androidx.annotation.DrawableRes

data class AppBarMenuItem(
    val text: String,
    @DrawableRes val drawable: Int,
    val onClick: () -> Unit,
) {
    companion object {
        val none = AppBarMenuItem(
            text = "",
            drawable = -1,
            onClick = {}
        )
    }
}
