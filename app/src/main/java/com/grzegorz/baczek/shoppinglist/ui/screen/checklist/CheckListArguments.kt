package com.grzegorz.baczek.shoppinglist.ui.screen.checklist

import com.grzegorz.baczek.shoppinglist.utils.base.BaseScreenArguments
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckListArguments(
    val id: Int? = null,
) : BaseScreenArguments
