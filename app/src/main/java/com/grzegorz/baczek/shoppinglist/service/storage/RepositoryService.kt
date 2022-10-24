package com.grzegorz.baczek.shoppinglist.service.storage

import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.utils.flow.stateFlowProperty
import kotlinx.coroutines.flow.StateFlow

class RepositoryService : IRepositoryService {

    private val _lists = stateFlowProperty(
        coroutineDispatcher = serviceDispatcher,
        coroutineScope = serviceScope,
        initialValue = mutableListOf<CheckList>(),
    )
    private val lists by _lists

    override fun getCheckLists(): StateFlow<List<CheckList>> = _lists.flow

    override fun getCheckList(id: Int): CheckList = lists.firstOrNull { it.id == id } ?: CheckList.empty

    override fun addCheckList(checkList: CheckList) {
        lists.add(checkList)
    }

    override fun removeCheckList(checkList: CheckList) {
        lists.remove(checkList)
    }
}