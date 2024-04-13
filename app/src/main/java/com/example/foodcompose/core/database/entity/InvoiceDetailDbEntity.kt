package com.example.foodcompose.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart")
data class InvoiceDetailDbEntity(
    @PrimaryKey val id: Int? = null,
    val productId: Int? = null,
    var qty: Double? = null,
    val name: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val calories: Double? = null,
    val protein: Double? = null,
    val fat: Double? = null,
    val carbs: Double? = null,
    val image: String? = null,
)