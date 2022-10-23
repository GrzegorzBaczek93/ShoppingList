package com.grzegorz.baczek.shoppinglist.model

data class CheckList(
    val id: Int,
    val title: String,
    val items: List<CheckListItem>,
) {
    companion object {
        val empty = CheckList(
            id = -1,
            title = "",
            items = emptyList()
        )
    }
}
