package com.grzegorz.baczek.shoppinglist.service.storage

import com.grzegorz.baczek.shoppinglist.model.CheckList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RepositoryService : IRepositoryService {

    private val lists = MutableStateFlow(emptyList<CheckList>())

    override fun getCheckLists(): StateFlow<List<CheckList>> = lists.asStateFlow()

    override fun addCheckList(checkList: CheckList) {
        lists.value = lists.value.plus(checkList)
    }

    override fun removeCheckList(checkList: CheckList) {
        lists.value = lists.value.minus(checkList)
    }
}