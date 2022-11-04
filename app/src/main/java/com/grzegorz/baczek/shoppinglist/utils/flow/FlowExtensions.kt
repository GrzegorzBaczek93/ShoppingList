package com.grzegorz.baczek.shoppinglist.utils.flow

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> stateFlowProperty(
    coroutineDispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope,
    initialValue: T,
) = StateFlowProperty(
    coroutineDispatcher,
    coroutineScope,
    initialValue,
)

class StateFlowProperty<T>(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val coroutineScope: CoroutineScope,
    initialValue: T,
) : ReadWriteProperty<Any?, T> {
    private val _flow = MutableStateFlow(initialValue)
    val flow: StateFlow<T> get() = _flow
    override fun getValue(thisRef: Any?, property: KProperty<*>): T = _flow.value
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        coroutineScope.launch(coroutineDispatcher) { _flow.emit(value) }
    }
}
