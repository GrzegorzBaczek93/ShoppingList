package com.grzegorz.baczek.shoppinglist.di

import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import org.koin.dsl.module

val utilsModule = module {
    single { NavigationHandler() }
}
