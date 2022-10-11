package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckListArguments(
    val id: Int
) : BaseArguments
