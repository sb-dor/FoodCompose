package com.example.foodcompose.features.invoice_feature.presentation.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InvoiceFeatureViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(InvoiceFeatureModel())
    val uiState: StateFlow<InvoiceFeatureModel> = _uiState.asStateFlow()

    fun addProductToInvoiceDetail(pizza: PizzaEntity) {
        uiState.value.invoiceDetails.add(InvoiceDetailEntity())
        _uiState.update {currentState ->
            currentState.copy(invoiceDetails = uiState.value.invoiceDetails)
        }


        println("length of current invoice detail list: ${_uiState.value.invoiceDetails.size}")
    }

}