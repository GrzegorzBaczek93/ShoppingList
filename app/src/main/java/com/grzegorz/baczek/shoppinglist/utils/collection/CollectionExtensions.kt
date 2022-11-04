package com.grzegorz.baczek.shoppinglist.utils.collection

fun <E> MutableCollection<E>.addAll(vararg elements: E) {
    elements.forEach { add(it) }
}
