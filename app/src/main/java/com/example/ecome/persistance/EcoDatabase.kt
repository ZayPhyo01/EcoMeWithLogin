package com.example.ecome.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ecome.data.vos.*

@Database(entities = arrayOf(CategoryVO::class, ProductVO::class,ProductImageVO::class,LoginVO::class,FavouriteVO::class), version = 7)
abstract class EcoDatabase : RoomDatabase() {

    abstract fun getFavouriteDao(): FavouriteDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getProductImageDao(): ProductImageDao
    abstract fun getUserLoginDao() : UserDao

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