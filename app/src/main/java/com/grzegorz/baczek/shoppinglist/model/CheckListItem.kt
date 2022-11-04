package com.grzegorz.baczek.shoppinglist.model

data class CheckListItem(
    val id: Int,
    val text: String,
    val checked: Boolean = false,
) {
    companion object {
        fun mock(id: Int = -1) = CheckListItem(
            id = id,
            text = "mocked list item",
        )
    }
}
