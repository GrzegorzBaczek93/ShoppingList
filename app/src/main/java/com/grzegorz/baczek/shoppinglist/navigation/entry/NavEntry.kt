package com.grzegorz.baczek.shoppinglist.navigation.entry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination

class NavEntry(
    private val viewModelStore: ViewModelStore,
    val destination: Destination,
): ViewModelStoreOwner {

    override fun getViewModelStore(): ViewModelStore = viewModelStore

    @Composable
    fun Component(
        content: @Composable () -> Unit,
    ) = CompositionLocalProvider(
        LocalViewModelStoreOwner provides this
    ) {
        content()
    }
}