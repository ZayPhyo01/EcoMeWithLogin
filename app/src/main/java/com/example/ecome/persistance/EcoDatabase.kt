package com.example.ecome.persistance


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecome.data.vos.*
import com.example.ecome.persistance.typeconveter.ImageTypeConveter

@Database(entities = arrayOf(CategoryVO::class, ProductVO::class,ProductImageVO::class,LoginVO::class, FavouriteVO::class), version = 17)
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