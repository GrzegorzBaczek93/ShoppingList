package com.grzegorz.baczek.shoppinglist.model

data class CheckListItem(
    val text: String,
    val checked: Boolean = false,
) {
    companion object {
        val mock = CheckListItem(
            text = "mocked list item",
        )
    }
}
