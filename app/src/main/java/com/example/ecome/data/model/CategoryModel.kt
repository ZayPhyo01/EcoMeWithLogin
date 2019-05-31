package com.example.ecome.data.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

object CategoryModel  : BaseModel( ), ICategory {


    fun getInstance() : CategoryModel = CategoryModel

    override fun getCategoryList( ): LiveData<MutableList<CategoryVO>> {


        mDataAgent.loadCategory(object : BaseDelegate<CategoryResponse> {
            override fun fail(message: String) {

            }

            override fun success(dataVo: CategoryResponse) {
                mEcoDatabase.getCategoryDao().insertCategory(dataVo.categoryList!!)



            }

        })

        return mEcoDatabase.getCategoryDao().getCategory()
    }

    fun isEmpty(): Boolean {
        return false
    }

}