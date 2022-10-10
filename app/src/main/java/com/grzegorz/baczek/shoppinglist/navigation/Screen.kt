package com.grzegorz.baczek.shoppinglist.navigation

import android.os.Parcelable
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeArguments
import com.grzegorz.baczek.shoppinglist.ui.screen.list.ListArguments
import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments
import kotlinx.parcelize.Parcelize

sealed class Screen(
    open val arguments: BaseArguments
) : Parcelable {

    @Parcelize
    data class Home(override val arguments: HomeArguments) : Screen(arguments)

    @Parcelize
    data class List(override val arguments: ListArguments) : Screen(arguments)
}