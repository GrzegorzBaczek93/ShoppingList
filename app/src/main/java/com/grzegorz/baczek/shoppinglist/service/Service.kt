package com.grzegorz.baczek.shoppinglist.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

interface Service {
    val serviceScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + Dispatchers.Default)
}