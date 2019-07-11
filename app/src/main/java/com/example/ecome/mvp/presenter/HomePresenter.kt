package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.view.HomeView

class HomePresenter : BasePresenter<HomeView>(), IHomePresenter {

    override fun onTapUnFav(id: Int) {
        productModel.unFavouriteWithId(id)
    }

    override fun onTapItem(id: Int) {
        productModel.saveProductHistoryWithId(id)
        mView.nevigateTo(id)

    }

    val categoModel: CategoryModel
    val productModel: ProductModel

    init {
        categoModel = CategoryModel.getInstance()
        productModel = ProductModel.getInstance()
    }



    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        categoModel.getCategoryList().observe(lifecycleOwner,object : Observer<MutableList<CategoryVO>>{
            override fun onChanged(t: MutableList<CategoryVO>?) {
                 mView.showCategoryList(t!!)
            }
        })

      productModel.getProducts().observe(lifecycleOwner,object : Observer<MutableList<ProductVO>>{
          override fun onChanged(t: MutableList<ProductVO>?) {
              mView.showProductList(t!!)
          }
      })
    }

    override fun onTapFav(id: Int) {
        productModel.favouriteWithId(id)

    }
}