package com.example.ecome.data.model

import android.util.Log
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse
import kotlin.collections.ArrayList

object ProductModel : BaseModel(), IProduct {

    override fun unFavouriteWithId(id: Int) {
         mEcoDatabase.getFavDao().deleteFavWithId(FavouriteVO(id))
    }


    /**
     * make favourite if already,abort it
     *
     */
    override fun favouriteWithId(id: Int) {
        Log.d("fav click"," done !")
        var eid = mEcoDatabase.getFavDao().insertFavProductId(FavouriteVO(id))
        Log.d("fav id : ", " $eid")
    }

    fun getInstance(): ProductModel = ProductModel



    override fun getProductHistory(): MutableList<ProductVO> {
        return if (mEcoDatabase.getProductDao().getProuductHistory() == null) {
            ArrayList()
        } else {
            mEcoDatabase.getProductDao().getProuductHistory()
        }
    }

    override fun saveProductHistoryWithId(id: Int) {
        mEcoDatabase.getProductDao().upDateProductCountWithId(id, mEcoDatabase.getProductDao())
    }


    override fun getFavouriteProuduct(): MutableList<ProductVO> {
        var favProducts = mEcoDatabase.getProductDao().getFavProduct()
        if (favProducts == null) {
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

                mEcoDatabase.getProductDao().insertProduct(dataVo.products)
                delegate.onSuccess(mEcoDatabase.getProductDao().getProduct(mEcoDatabase.getFavDao(),mEcoDatabase.getProductDao()))
            }
        })
        val result = mEcoDatabase.getProductDao().getProduct(mEcoDatabase.getFavDao(),mEcoDatabase.getProductDao())
        return result
    }

}