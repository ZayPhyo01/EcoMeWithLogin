package com.example.ecome.data.model

import android.content.Context
import android.util.Log
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse

object ProductModel   : BaseModel( ), IProduct {

    fun getInstance() : ProductModel = ProductModel

    override fun getProcuctHistory(): MutableList<ProductVO> {
         return if(mEcoDatabase.getProductDao().getProuductHistory()==null) { ArrayList()} else{ mEcoDatabase.getProductDao().getProuductHistory()}
    }

    override fun saveProductHistoryWithId(id: Int) {
       mEcoDatabase.getProductDao().upDateProductCountWithId(id,mEcoDatabase.getProductDao())
    }

    override fun favouriteWithId(id: Int) {
       var id = mEcoDatabase.getFavDao().saveFavProductWithId(id)
        Log.d("fav id : "," $id")
    }

    override fun getFavouriteProuduct(): MutableList<ProductVO> {
        var favProducts = mEcoDatabase.getProductDao().getFavProduct()
        if(favProducts == null) {
            favProducts = ArrayList()
        }
        return favProducts
    }

    override fun getProductsById(id: Int): ProductVO {
        return mEcoDatabase.getProductDao()
            .getProductById(id)
    }


    override fun getProducts(delegate: IProduct.ProductDelegate): MutableList<ProductVO> {

        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {
                delegate.onError(message)
            }

            override fun success(dataVo: ProductResponse) {

                delegate.onSuccess(dataVo.products)
                //  val debug = dataVo.products!!


                mEcoDatabase.getProductDao().insertProduct(dataVo.products)



            }

        })
        val result = mEcoDatabase.getProductDao().getProduct()
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