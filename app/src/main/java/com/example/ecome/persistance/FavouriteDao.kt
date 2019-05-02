package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.support.v7.view.menu.ListMenuItemView
import com.example.ecome.data.vos.FavouriteVO


@Dao
abstract class FavouriteDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    abstract fun insertFavProductId(favouriteVO: FavouriteVO) : Long

    fun saveFavProductWithId(id : Int) : Int {
        var favouriteVO = FavouriteVO(id)
        var id = insertFavProductId(favouriteVO)
        return id.toInt()
    }








}