package com.grzegorz.baczek.shoppinglist.di

import com.grzegorz.baczek.shoppinglist.navigation.service.INavigationService
import com.grzegorz.baczek.shoppinglist.navigation.service.NavigationService
import com.grzegorz.baczek.shoppinglist.service.storage.IRepositoryService
import com.grzegorz.baczek.shoppinglist.service.storage.RepositoryService
import org.koin.dsl.module

val serviceModule = module {
    single<IRepositoryService> { RepositoryService() }
    single<INavigationService> { NavigationService() }
}
