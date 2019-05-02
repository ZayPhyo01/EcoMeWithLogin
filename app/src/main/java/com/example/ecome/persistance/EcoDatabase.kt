package com.example.ecome.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ecome.data.vos.*

@Database(entities = arrayOf(CategoryVO::class, ProductVO::class,ProductImageVO::class,LoginVO::class, FavouriteVO::class), version = 9)
abstract class EcoDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getProductImageDao(): ProductImageDao
    abstract fun getUserDao() : UserDao
    abstract fun getFavDao() : FavouriteDao

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