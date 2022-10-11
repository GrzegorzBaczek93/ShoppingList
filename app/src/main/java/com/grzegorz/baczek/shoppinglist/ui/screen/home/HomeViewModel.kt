package com.grzegorz.baczek.shoppinglist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.grzegorz.baczek.shoppinglist.model.CheckList
import com.grzegorz.baczek.shoppinglist.model.CheckListItem
import com.grzegorz.baczek.shoppinglist.navigation.NavigationHandler
import com.grzegorz.baczek.shoppinglist.utils.base.BaseViewModel

class HomeViewModel(
    private val navigationHandler: NavigationHandler,
) : BaseViewModel<HomeArguments>() {

    var state by mutableStateOf<HomeScreenState>(HomeScreenState.Content)
        private set

    var searchText by mutableStateOf("")
        private set

    var data by mutableStateOf<List<CheckList>>(emptyList())
        private set

    override fun onArgumentsObtained(args: HomeArguments) {
        super.onArgumentsObtained(args)
        setMocks()
    }

    fun onSearchTextChanged(text: String) {
        searchText = text
    }

    fun onCancelClick() {
        searchText = ""
    }

    private fun setMocks() {
        data = listOf(
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            ),
            CheckList(
                id = "0",
                title = "Check List",
                items = listOf(
                    CheckListItem(
                        "First item"
                    ),
                    CheckListItem(
                        "Second item"
                    ),
                    CheckListItem(
                        "Third item"
                    ),
                    CheckListItem(
                        "Fourth item"
                    )
                )
            )
        )
    }
}
