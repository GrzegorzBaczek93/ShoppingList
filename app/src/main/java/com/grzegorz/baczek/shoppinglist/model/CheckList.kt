package com.grzegorz.baczek.shoppinglist.model

data class CheckList(
    val id: String,
    val title: String,
    val items: List<CheckListItem>,
)
