package com.example.ecome.persistance


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ecome.data.vos.LoginVO

@Dao
abstract class UserDao {

    @Insert
    abstract fun saveUserLogin(loginVO: LoginVO)

    @Query("Select * from user_table")
    abstract fun getUserLogin() : LoginVO

    fun isEmpty(userDao: UserDao): Boolean = userDao.getUserLogin() == null


}