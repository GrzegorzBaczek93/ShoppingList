package com.grzegorz.baczek.shoppinglist.navigation.destination

import android.os.Parcelable
import androidx.compose.runtime.Composable

interface Destination: Parcelable {
    @Composable
    fun Content() {}
}