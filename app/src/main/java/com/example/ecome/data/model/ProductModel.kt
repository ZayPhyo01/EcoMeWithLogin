package com.example.ecome.data.model

import android.content.Context
import android.util.Log
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse

class ProductModel private constructor(context: Context) : BaseModel(context), IProduct {

    override fun favouriteWithId(id: Int) {
       var id = mEcoDatabase.getFavDao().saveFavProductWithId(id)
        Log.d("fav id : "," $id")
    }

    override fun getFavouriteProuduct(): MutableList<ProductVO> {
        val favProducts = mEcoDatabase.getProductDao().getFavProduct()
        return favProducts
    }

    override fun getProductsById(id: Int): ProductVO {
        return mEcoDatabase.getProductDao()
            .getProductsWithId(mEcoDatabase.getProductImageDao(), mEcoDatabase.getProductDao(), id)
    }


    companion object {

        fun initProductModel(context: Context) {
            if (productModel == null) {
                productModel = ProductModel(context)
            }
        }

        var productModel: ProductModel? = null

        fun getInstance(): ProductModel {

            return productModel!!

        }
    }

    override fun getProducts(delegate: IProduct.ProductDelegate): MutableList<ProductVO> {

        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {
                delegate.onError(message)
            }

            override fun success(dataVo: ProductResponse) {

                delegate.onSuccess(dataVo.products)
                //  val debug = dataVo.products!!


                mEcoDatabase.getProductDao().saveProductsWithItems(
                    dataVo.products, mEcoDatabase.getProductImageDao(),
                    mEcoDatabase.getProductDao()
                )


            }

        })
        val result = mEcoDatabase.getProductDao().getProductsWithItems(
            mEcoDatabase.getProductImageDao(),
            mEcoDatabase.getProductDao()
        )
        return result
    }

    fun isEmpty(): Boolean {
        return if (mEcoDatabase.getProductDao().getProduct() == null) {
            true
        } else {
            false
        }
    }


}