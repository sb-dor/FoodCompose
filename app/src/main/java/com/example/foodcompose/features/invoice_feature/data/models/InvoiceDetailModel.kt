package com.example.foodcompose.features.invoice_feature.data.models

import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity

class InvoiceDetailModel(
    pizza: PizzaEntity? = null,
    qty: Double? = null,
    price: Double? = null
) : InvoiceDetailEntity(pizza = pizza, qty = qty, price = price) {


    // means like static fields in Dart
    companion object {
        fun fromEntity(entity: InvoiceDetailEntity? = null): InvoiceDetailModel? {
            if (entity == null) return null;
            return InvoiceDetailModel(
                pizza = entity.pizza,
                qty = entity.qty,
                price = entity.price,
            );
        }
    }

    fun copyWith(
        pizza: PizzaEntity? = null,
        qty: Double? = null,
        price: Double? = null
    ): InvoiceDetailModel {
        return InvoiceDetailModel(
            pizza = pizza ?: this.pizza,
            qty = qty ?: this.qty,
            price = price ?: this.price,
        )
    }


    fun total(): Double {
        return (qty ?: 1.0) * (price ?: 0.0);
    }

}