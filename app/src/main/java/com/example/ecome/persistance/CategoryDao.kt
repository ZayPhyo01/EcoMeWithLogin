package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.CategoryVO

@Dao
abstract  class CategoryDao {

    @Query("Select * from category")
    abstract fun getCategory() : MutableList<CategoryVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCategory(categories : MutableList<CategoryVO>)


}