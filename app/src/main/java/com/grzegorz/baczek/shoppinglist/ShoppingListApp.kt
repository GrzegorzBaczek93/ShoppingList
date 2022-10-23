package com.grzegorz.baczek.shoppinglist

import android.app.Application
import com.grzegorz.baczek.shoppinglist.di.serviceModule
import com.grzegorz.baczek.shoppinglist.di.utilsModule
import com.grzegorz.baczek.shoppinglist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ShoppingListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ShoppingListApp)
            modules(viewModelModule, serviceModule, utilsModule)
        }
    }
}
