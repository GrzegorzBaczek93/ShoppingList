package com.grzegorz.baczek.shoppinglist.ui.screen.list

import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel
import com.grzegorz.baczek.shoppinglist.utils.log.logD

class ListViewModel : BaseViewModel<ListArguments>() {

    override fun onArgumentsObtained(args: ListArguments) {
        super.onArgumentsObtained(args)
        logD("onArgumentsObtained $args")
    }
}