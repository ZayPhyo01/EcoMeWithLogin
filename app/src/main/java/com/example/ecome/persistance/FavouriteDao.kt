package com.example.ecome.persistance

import android.arch.persistence.room.*
import com.example.ecome.data.vos.FavouriteVO


@Dao
abstract class FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavProductId(favouriteVO: FavouriteVO): Long

    @Query("Select * from fav_table where favProductId = :fid")
    abstract fun getFavItemWithId(fid: Int): FavouriteVO

    @Delete
    abstract fun removeFavItem(favouriteVO: FavouriteVO)


    //Todo to ask because I think this method against single reponsiblity principle.This reposible should be in the dao or model
    fun saveFavProductWithId(id: Int) {
        var favouriteVO = FavouriteVO(id)
        var favItem = getFavItemWithId(id)
        if (favItem == null) {
            //item is not favourite
            insertFavProductId(favouriteVO)
        } else {
            //item already favourite
            removeFavItem(favouriteVO)

        }


    }


}