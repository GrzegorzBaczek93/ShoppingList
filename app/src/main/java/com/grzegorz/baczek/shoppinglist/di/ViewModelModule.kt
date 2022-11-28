package com.grzegorz.baczek.shoppinglist.di

import com.grzegorz.baczek.shoppinglist.ui.activity.MainActivityViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CheckListViewModel(get(), get()) }
}
