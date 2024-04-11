package com.example.foodcompose.features.invoice_feature.domain.entities

import com.example.foodcompose.core.domain.entities.PizzaEntity

open class InvoiceDetailEntity(
    val pizza: PizzaEntity? = null,
    var qty: Double? = null,
    var price: Double? = null
)