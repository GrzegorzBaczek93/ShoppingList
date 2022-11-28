package com.grzegorz.baczek.shoppinglist.utils.collection

import java.util.Stack

fun <E> MutableCollection<E>.addAll(vararg elements: E) {
    elements.forEach { add(it) }
}

fun <E, R> Stack<E>?.ifNotEmptyOrNull(action: Stack<E>.() -> R?): R? = if (this.isNullOrEmpty()) null else action()
