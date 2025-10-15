package com.example.unit6_pathway2_inventory.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import com.example.unit6_pathway2_inventory.data.Item
import com.example.unit6_pathway2_inventory.data.ItemsRepository

data class HomeUiState(val itemList: List<Item> = listOf())

class HomeViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    // Expose a StateFlow for the UI to observe
    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream()       // Flow<List<Item>>
            .map { HomeUiState(it) }              // chuyển thành HomeUiState
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}