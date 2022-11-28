package com.grzegorz.baczek.shoppinglist.utils.base

import androidx.lifecycle.ViewModel

/**
 * Base ViewModel for all ViewModels in the app
 */
abstract class BaseViewModel<in A : BaseArguments> : ViewModel() {

    var argsSet = false

    open fun onArgumentsObtained(args: A) {}

    open fun onResume() {}

    open fun onPause() {}

    @Suppress("UNCHECKED_CAST")
    fun setArguments(args: BaseArguments) {
        synchronized(this) {
            if (!argsSet) {
                argsSet = true
                onArgumentsObtained(args as A)
            }
        }
    }
}
