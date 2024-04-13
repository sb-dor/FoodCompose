package com.example.foodcompose.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.foodcompose.core.database.entity.InvoiceDetailDbEntity


@Dao
interface InvoiceDetailsDataAccessObject {

    @Query("SELECT * FROM cart")
    suspend fun getAllLocalInvoiceDetails(): List<InvoiceDetailDbEntity>


    @Query("UPDATE cart SET qty = :qty WHERE productId = :productId")
    suspend fun updateLocalInvoiceDetail(productId: Int?, qty: Double?)


    @Insert
    suspend fun insertLocalInvoiceDetail(invoiceDetail: InvoiceDetailDbEntity)


    @Query("DELETE FROM cart WHERE productId = :productId")
    suspend fun removeFromInvoice(productId: Int)
}