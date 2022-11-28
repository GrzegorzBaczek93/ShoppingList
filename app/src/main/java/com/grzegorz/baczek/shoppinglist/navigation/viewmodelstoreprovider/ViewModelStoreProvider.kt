package com.grzegorz.baczek.shoppinglist.navigation.viewmodelstoreprovider

import androidx.lifecycle.ViewModelStore

class ViewModelStoreProvider {
    private val viewModelStores: MutableMap<String, ViewModelStore> = mutableMapOf()

    fun getViewModelStore(id: String): ViewModelStore = viewModelStores.getOrPut(id) { ViewModelStore() }

    fun clearViewModelStore(id: String) {
        viewModelStores.remove(id)?.clear()
    }
}
