package com.grzegorz.baczek.shoppinglist.navigation.service

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.StateFlow

interface INavigationService {
    val isBackEnabled: Boolean

    fun getCurrentScreenState(): StateFlow<NavState>

    fun getCurrentDialogState(): StateFlow<NavState>

    fun navigateTo(destination: Destination)

    fun pop()

    fun <T : Destination> popUntil(destination: KClass<T>)
}
