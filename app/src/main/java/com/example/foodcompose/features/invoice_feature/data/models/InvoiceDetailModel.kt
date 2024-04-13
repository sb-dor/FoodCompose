package com.example.foodcompose.features.invoice_feature.data.models

import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.core.database.entity.InvoiceDetailDbEntity
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

        fun fromLocalTable(invoiceDbEntity: InvoiceDetailDbEntity? = null): InvoiceDetailModel? {
            if (invoiceDbEntity == null) return null;
            return InvoiceDetailModel(
                pizza = PizzaEntity(
                    cId = invoiceDbEntity.productId,
                    cName = invoiceDbEntity.name,
                    cDescription = invoiceDbEntity.description,
                    cPrice = invoiceDbEntity.price,
                    cCalories = invoiceDbEntity.calories,
                    cProtein = invoiceDbEntity.protein,
                    cFat = invoiceDbEntity.fat,
                    cCarbs = invoiceDbEntity.carbs,
                    cImage = invoiceDbEntity.image,
                ),
                price = invoiceDbEntity.price,
                qty = invoiceDbEntity.qty,
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

    fun toLocalTable(): InvoiceDetailDbEntity {
        return InvoiceDetailDbEntity(
            productId = pizza?.id,
            name = pizza?.name,
            description = pizza?.description,
            price = price,
            calories = pizza?.calories,
            protein = pizza?.protein,
            fat = pizza?.fat,
            carbs = pizza?.carbs,
            image = pizza?.image,
        );
    }

}