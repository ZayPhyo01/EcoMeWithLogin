package com.example.ecome.mvp.presenter

import android.util.Log
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ICategory
import com.example.ecome.data.model.IProduct
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.view.HomeView

class HomePresenter(val homeView: HomeView) : BasePresenter(), IHomePresenter {

    override fun onTapUnFav(id: Int) {
        productModel.unFavouriteWithId(id)
    }

    override fun onTapItem(id: Int) {
        productModel.saveProductHistoryWithId(id)
        homeView.nevigateTo(id)

    }

    val categoModel: CategoryModel
    val productModel: ProductModel

    init {
        categoModel = CategoryModel.getInstance()
        productModel = ProductModel.getInstance()
    }

    override fun onCreate() {

    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {

    }

    override fun onUiReady() {
        categoModel.getCategoryList(object : ICategory.CategoryResult {
            override fun onSuccess(categories: MutableList<CategoryVO>) {
                homeView.showCategoryList(categories)
            }

            override fun onError(message: String) {
            }
        })

        var dataforPresesitence = productModel.getProducts(object : IProduct.ProductDelegate {
            override fun onSuccess(products: MutableList<ProductVO>) {
                var debug = products
                homeView.showProductList(products)
            }

            override fun onError(message: String) {

            }

        })
        if (dataforPresesitence != null) {
            homeView.showProductList(dataforPresesitence)
            Log.d("this line ", "work")
        }
    }

    override fun onTapFav(id: Int) {
        productModel.favouriteWithId(id)
        Log.d("presenter", "id = $id")
    }
}