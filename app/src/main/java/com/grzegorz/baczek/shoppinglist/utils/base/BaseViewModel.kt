package com.grzegorz.baczek.shoppinglist.utils.base

import androidx.lifecycle.ViewModel

/**
 * Base ViewModel for all ViewModels in the app
 */
abstract class BaseViewModel<in T: BaseArguments>: ViewModel() {

    private var areSet = false

    open fun onArgumentsObtained(args: T) {}

    @Suppress("UNCHECKED_CAST")
    fun setArguments(args: BaseArguments) {
        if (areSet.not()) {
            areSet = true
            onArgumentsObtained(args as T)
        }
    }
}