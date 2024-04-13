package com.example.foodcompose.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodcompose.core.database.dao.InvoiceDetailsDataAccessObject
import com.example.foodcompose.core.database.entity.InvoiceDetailDbEntity


@Database(entities = [InvoiceDetailDbEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getInvoiceDetailDao(): InvoiceDetailsDataAccessObject


    companion object {
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance: LocalDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    name = "food_composed_db"
                ).build()

                INSTANCE = instance

                instance


            }
        }
    }
}