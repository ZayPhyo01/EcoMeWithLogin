package com.example.ecome

import android.app.Application
import com.example.ecome.data.model.BaseModel
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.persistance.EcoDatabase

class EcoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CategoryModel.initCategoryModel(applicationContext)
        ProductModel.initProductModel(applicationContext)
        UserModel.initUserModel(applicationContext)
    }
}