package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

object CategoryModel  : BaseModel( ), ICategory {


    fun getInstance() : CategoryModel = CategoryModel

    override fun getCategoryList(result: ICategory.CategoryResult): MutableList<CategoryVO> {


        mDataAgent.loadCategory(object : BaseDelegate<CategoryResponse> {
            override fun fail(message: String) {
                result.onError(message)
            }

            override fun success(dataVo: CategoryResponse) {
                mEcoDatabase.getCategoryDao().insertCategory(dataVo.categoryList!!)

                result.onSuccess(dataVo.categoryList)


            }

        })

        return mEcoDatabase.getCategoryDao().getCategory()
    }

    fun isEmpty(): Boolean {
        return mEcoDatabase.getCategoryDao().getCategory().isEmpty()
    }

}