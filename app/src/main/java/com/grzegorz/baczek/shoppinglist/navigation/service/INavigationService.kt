package com.grzegorz.baczek.shoppinglist.navigation.service

import com.grzegorz.baczek.shoppinglist.navigation.destination.Destination
import com.grzegorz.baczek.shoppinglist.navigation.state.NavState
import kotlinx.coroutines.flow.StateFlow

interface INavigationService {
    val isBackEnabled: Boolean

    fun getCurrentState(): StateFlow<NavState>

    fun navigateTo(destination: Destination)

    fun pop()
}