package com.example.ecome.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse
import kotlin.collections.ArrayList

object ProductModel : BaseModel(), IProduct {

    override fun unFavouriteWithId(id: Int) {
        mEcoDatabase.getFavDao().deleteFavWithId(FavouriteVO(id))
        mEcoDatabase.getProductDao().updateFavToProduct(id, false)
    }


    /**
     * make favourite if already,abort it
     *
     */
    override fun favouriteWithId(id: Int) {
        mEcoDatabase.getFavDao().insertFavProductId(FavouriteVO(id))
        mEcoDatabase.getProductDao().updateFavToProduct(id, true)


    }

    fun getInstance(): ProductModel = ProductModel


    override fun getProductHistory(): LiveData<MutableList<ProductVO>> {
        return mEcoDatabase.getProductDao().getProuductHistory()

    }

    override fun saveProductHistoryWithId(id: Int) {
        mEcoDatabase.getProductDao().upDateProductCountWithId(id, mEcoDatabase.getProductDao())
    }


    override fun getFavouriteProuduct(): LiveData<MutableList<ProductVO>> {
        var favProducts = mEcoDatabase.getProductDao().getFavProduct()
        return favProducts
    }

    override fun getProductsById(id: Int): LiveData<ProductVO> {
        return mEcoDatabase.getProductDao().getProductById(id)
    }


    override fun getProducts(): LiveData<MutableList<ProductVO>> {

        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {

            }

            override fun success(dataVo: ProductResponse) {
                mEcoDatabase.getProductDao().insertProduct(dataVo.products)
            }
        })
        /*val result = mEcoDatabase.getProductDao().getProduct(mEcoDatabase.getFavDao(),mEcoDatabase.getProductDao())
        return result*/
        return mEcoDatabase.getProductDao().getProductFormDatabase()
    }

}