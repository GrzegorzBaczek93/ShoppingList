package com.grzegorz.baczek.shoppinglist.di

import com.grzegorz.baczek.shoppinglist.ui.activity.MainActivityViewModel
import com.grzegorz.baczek.shoppinglist.ui.dialog.doublebutton.DoubleButtonDialogViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.checklist.CheckListScreenViewModel
import com.grzegorz.baczek.shoppinglist.ui.screen.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }

    viewModel { HomeScreenViewModel(get(), get()) }
    viewModel { CheckListScreenViewModel(get(), get()) }

    viewModel { DoubleButtonDialogViewModel() }
}
