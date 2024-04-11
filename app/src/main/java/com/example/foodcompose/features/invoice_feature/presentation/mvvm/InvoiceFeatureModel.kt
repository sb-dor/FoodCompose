package com.example.foodcompose.features.invoice_feature.presentation.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity

data class InvoiceFeatureModel (
    var invoiceDetails: SnapshotStateList<InvoiceDetailEntity> = mutableStateListOf()
)