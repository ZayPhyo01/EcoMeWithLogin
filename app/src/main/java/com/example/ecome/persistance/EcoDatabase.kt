package com.example.ecome.persistance

import android.arch.persistence.room.*
import android.content.Context
import com.example.ecome.data.vos.*
import com.example.ecome.persistance.typeconveter.ImageTypeConveter

@Database(entities = arrayOf(CategoryVO::class, ProductVO::class,ProductImageVO::class,LoginVO::class, FavouriteVO::class), version = 14)
@TypeConverters(ImageTypeConveter::class)
abstract class EcoDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getProductImageDao(): ProductImageDao
    abstract fun getUserDao() : UserDao
    abstract fun getFavDao() : FavouriteDao

    companion object {
        val DATABASE_NAME = "EcoMe.db"
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