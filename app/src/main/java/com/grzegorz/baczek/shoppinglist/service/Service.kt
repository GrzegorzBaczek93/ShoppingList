package com.grzegorz.baczek.shoppinglist.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

interface Service {
    val serviceDispatcher: CoroutineDispatcher
        get() = Dispatchers.Default

    val serviceScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + serviceDispatcher)
}
