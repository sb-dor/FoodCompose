package com.example.foodcompose.features.invoice_feature.data.models

import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity

class InvoiceDetailModel(
    pizza: PizzaEntity? = null,
    qty: Double? = null,
    price: Double? = null
) : InvoiceDetailEntity(pizza = pizza, qty = qty, price = price) {
}