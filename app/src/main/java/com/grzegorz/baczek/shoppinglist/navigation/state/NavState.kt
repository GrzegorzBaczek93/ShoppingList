package com.grzegorz.baczek.shoppinglist.navigation.state

import com.grzegorz.baczek.shoppinglist.navigation.entry.NavEntry

sealed class NavState {

    object Empty : NavState()

    data class Entry(
        val entry: NavEntry
    ) : NavState()
}
