package com.grzegorz.baczek.shoppinglist.navigation.destination

import com.grzegorz.baczek.shoppinglist.utils.base.BaseArguments

sealed class Dialog(
    open val arguments: BaseArguments,
) : Destination
