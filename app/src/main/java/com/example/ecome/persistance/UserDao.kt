package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.LoginVO

@Dao
interface UserDao {

    @Insert
    fun saveUserLogin(loginVO: LoginVO)

    @Query("Select count(*) from user_table")
    fun getUserLogin() : Int
}