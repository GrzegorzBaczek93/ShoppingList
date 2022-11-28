package com.grzegorz.baczek.shoppinglist.navigation.stack

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.entry.NavEntry
import com.grzegorz.baczek.shoppinglist.utils.collection.ifNotEmptyOrNull
import java.util.Stack
import kotlin.reflect.KClass

class NavStack {
    private val screenStack: Stack<NavEntry> = Stack()
    private val dialogStack: Stack<NavEntry> = Stack()

    /**
     * Pushes [NavEntry] to proper stack and return it
     */
    fun push(navEntry: NavEntry): NavEntry = getActiveStack(navEntry).push(navEntry)

    /**
     * Pops top [NavEntry] from current active stack and return it
     */
    fun pop(): NavEntry? = getActiveStack()?.pop()

    /**
     * Simple check if pop is allowed (there are any elements at active stack)
     */
    fun allowPop(): Boolean = getActiveStack()?.size?.let { it > 1 } ?: false

    /**
     * Returns top [NavEntry] from current active stack
     */
    fun peek(): NavEntry? = getActiveStack()?.peek()

    /**
     * Return top [NavEntry] based on param type or null if empty
     */
    fun <T : Destination> peek(type: KClass<T>): NavEntry? = when (type) {
        Destination.Dialog::class -> dialogStack
        Destination.Screen::class -> screenStack
        else -> null
    }.ifNotEmptyOrNull { peek() }

    /**
     * Returns true if any screen or dialog stack contains element of given type
     */
    fun <T : Destination> contains(type: KClass<T>): Boolean = dialogStack.contains(type) || screenStack.contains(type)

    /**
     * Gets current active stack -> if there is anything of top of dialog stack -> it is "active"
     * otherwise it is screenstack if it's also not empty
     * As a fallback it will just return null
     */
    private fun getActiveStack(): Stack<NavEntry>? = when {
        dialogStack.isNotEmpty() -> dialogStack
        screenStack.isNotEmpty() -> screenStack
        else -> null
    }

    /**
     * Gets stack based on type of NavEntry destination
     */
    private fun getActiveStack(entry: NavEntry): Stack<NavEntry> = when (entry.destination) {
        is Destination.Dialog -> dialogStack
        else -> screenStack
    }
}

private fun <T : Destination> Stack<NavEntry>.contains(type: KClass<T>): Boolean {
    if (this.isNotEmpty()) {
        for (element in this) {
            if (element.destination::class == type) {
                return true
            }
        }
    }
    return false
}
