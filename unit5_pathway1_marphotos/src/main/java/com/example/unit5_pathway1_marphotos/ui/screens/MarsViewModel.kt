package com.example.unit5_pathway1_marphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MarsViewModel : ViewModel() {
    var marsUiState: String by mutableStateOf("")
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        marsUiState = "Set the Mars API status response here!"
    }
}