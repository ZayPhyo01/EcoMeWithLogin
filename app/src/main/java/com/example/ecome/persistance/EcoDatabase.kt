package com.example.ecome.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductImageVO
import com.example.ecome.data.vos.ProductVO

@Database(entities = arrayOf(CategoryVO::class, ProductVO::class,ProductImageVO::class), version = 4)
abstract class EcoDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getProductImageDao(): ProductImageDao

    companion object {
        val DATABASE_NAME = "ecodatabase1"
        var database: EcoDatabase? = null

        fun getInstance(context: Context): EcoDatabase {

            if (database == null) {
                database = Room.databaseBuilder(context, EcoDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database!!

        }
    }

}