package com.grzegorz.baczek.shoppinglist.service.storage

import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.service.Service
import kotlinx.coroutines.flow.StateFlow

interface IRepositoryService: Service {

    fun getCheckLists(): StateFlow<List<CheckList>>

    fun addCheckList(checkList: CheckList)

    fun removeCheckList(checkList: CheckList)
}