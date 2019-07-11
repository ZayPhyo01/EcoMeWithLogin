package com.example.ecome.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.presenter.IHomePresenter

class HomeViewModel : ViewModel(), IHomeViewModel {
    override fun onTapItem(id: Int) {
         mProductModel.saveProductHistoryWithId(id)
    }

    override fun onTapFavourite(id: Int) {
         mProductModel.favouriteWithId(id)
    }

    override fun onTapUnFavourite(id: Int) {
         mProductModel.unFavouriteWithId(id)
          }


    val mProductModel = ProductModel
    val mCategoryModel = CategoryModel

    override fun getCategories(): LiveData<MutableList<CategoryVO>> {
        return mCategoryModel.getCategoryList()
    }

    override fun getProducts(): LiveData<MutableList<ProductVO>> {
        return mProductModel.getProducts()
    }


}