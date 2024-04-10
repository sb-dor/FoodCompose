package com.example.foodcompose.features.invoice_feature.presentation.mvvm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.foodcompose.core.domain.entities.PizzaEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InvoiceFeatureViewModel : ViewModel() {


     val invoiceDetailsList = mutableStateListOf<PizzaEntity>()


    fun addProductToInvoiceDetail(pizza: PizzaEntity) {
        invoiceDetailsList.add(pizza)
    }

}