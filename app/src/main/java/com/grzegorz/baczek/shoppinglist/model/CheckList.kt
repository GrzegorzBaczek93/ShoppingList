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
            items = List(size) { CheckListItem.mock(it) }
        )
    }
}

/**
 * Inverts checked flag of item assigned to given @param id [Int]
 */
fun CheckList.toggled(id: Int) = copy(items = items.map { if (it.id == id) it.copy(checked = it.checked.not()) else it })

/**
 * Set all items checked flag to false
 */
fun CheckList.cleared() = copy(items = items.map { it.copy(checked = false) })
