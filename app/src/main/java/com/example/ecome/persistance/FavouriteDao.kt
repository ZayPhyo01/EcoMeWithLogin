package com.example.ecome.persistance


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ecome.data.vos.FavouriteVO


@Dao
abstract class FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertFavProductId(favouriteVO: FavouriteVO): Long

    @Delete
    abstract fun deleteFavWithId(favouriteVO: FavouriteVO)

    @Query("Select * from fav_table where favProductId = :fid")
    abstract fun getFavItemWithId(fid: Int): LiveData<FavouriteVO>

    @Query("Select * from fav_table")
    abstract fun getFavItemId(): LiveData<MutableList<FavouriteVO>>



}