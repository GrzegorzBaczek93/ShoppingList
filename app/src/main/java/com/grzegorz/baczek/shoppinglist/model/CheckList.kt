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
        fun mock(id: Int, size: Int) = CheckList(
            id = id,
            title = "mocked check list #$id",
            items = List(size) { CheckListItem.mock }
        )
    }
}
