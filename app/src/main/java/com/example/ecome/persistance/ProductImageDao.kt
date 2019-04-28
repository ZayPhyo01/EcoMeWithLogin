package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.ProductImageVO

@Dao
interface ProductImageDao {

    @Query("Select * from product_images")
    fun getProductImage() : MutableList<ProductImageVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProductImage(images : ArrayList<ProductImageVO>) : List<Long>

    @Query("Select * from product_images where product_id = :id")
    fun getProductImageById(id : Int) : MutableList<ProductImageVO>

}