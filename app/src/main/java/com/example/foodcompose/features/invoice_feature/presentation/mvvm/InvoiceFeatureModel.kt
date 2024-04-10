package com.example.foodcompose.features.invoice_feature.presentation.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.foodcompose.core.domain.entities.PizzaEntity

class InvoiceFeatureModel {
    val invoiceDetailsList = mutableStateListOf<PizzaEntity>()
}