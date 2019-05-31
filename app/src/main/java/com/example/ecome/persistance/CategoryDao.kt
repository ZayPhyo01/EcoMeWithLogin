package com.example.ecome.persistance


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecome.data.vos.CategoryVO

@Dao
abstract  class CategoryDao {

    @Query("Select * from category")
    abstract fun getCategory() : LiveData<MutableList<CategoryVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCategory(categories : MutableList<CategoryVO>)


}