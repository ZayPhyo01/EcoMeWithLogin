package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

class CategoryModel private constructor(context: Context) : BaseModel(context), ICategory {


    companion object {
        var INSTANCE: CategoryModel? = null

        fun initCategoryModel(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = CategoryModel(context)
            }
        }

        fun getInstance(): CategoryModel {

            return INSTANCE!!

        }
    }

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