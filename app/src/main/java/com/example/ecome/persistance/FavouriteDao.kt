package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.ProductVO

@Dao
interface FavouriteDao {
    @Query("Select * from product inner join fav_table")
    fun getFavouriteProduct () : MutableList<ProductVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavouriteProduct(id : Int)
}