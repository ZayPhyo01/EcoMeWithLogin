package com.example.ecome.persistance


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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