package com.grzegorz.baczek.shoppinglist.navigation.stack

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.entry.NavEntry
import com.grzegorz.baczek.shoppinglist.utils.collection.ifNotEmptyOrNull
import java.util.Stack
import kotlin.reflect.KClass

class NavStack {
    private val screenStack: Stack<NavEntry> = Stack()
    private val dialogStack: Stack<NavEntry> = Stack()

    fun push(navEntry: NavEntry): NavEntry = getActiveStack(navEntry).push(navEntry)

    fun pop(): NavEntry? = getActiveStack().pop()

    fun allowPop(): Boolean = getActiveStack().size > 1

    fun <T : Destination> peek(type: KClass<T>): NavEntry? = when (type) {
        Destination.Dialog::class -> dialogStack
        Destination.Screen::class -> screenStack
        else -> null
    }.ifNotEmptyOrNull { peek() }

    private fun getActiveStack(): Stack<NavEntry> = when {
        dialogStack.isNotEmpty() -> dialogStack
        else -> screenStack
    }

    private fun getActiveStack(entry: NavEntry): Stack<NavEntry> = when (entry.destination) {
        is Destination.Dialog -> dialogStack
        else -> screenStack
    }
}