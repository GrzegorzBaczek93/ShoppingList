package com.grzegorz.baczek.shoppinglist.utils.base

import androidx.lifecycle.ViewModel

/**
 * Base ViewModel for all ViewModels in the app
 */
abstract class BaseScreenViewModel<in T : BaseScreenArguments> : ViewModel() {

    private var areSet = false

    open fun onArgumentsObtained(args: T) {}

    @Suppress("UNCHECKED_CAST")
    fun setArguments(args: BaseScreenArguments) {
        if (areSet.not()) {
            areSet = true
            onArgumentsObtained(args as T)
        }
    }
}
