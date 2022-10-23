package com.grzegorz.baczek.shoppinglist.di

import com.grzegorz.baczek.shoppinglist.ui.navigation.NavigationViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { params -> NavigationViewModel(params.get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CheckListViewModel(get()) }
}
