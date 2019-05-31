package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.view.DetailProductView

class DetailProductPresenter (): BasePresenter<DetailProductView>(),IDetailProductPresenter{

    override fun onUiReady(id: Int,lifecycleOwner: LifecycleOwner) {
        productModel.getProductsById(id).observe(lifecycleOwner,object : Observer<ProductVO>{
            override fun onChanged(t: ProductVO?) {
                mView.showDetailProduct(t!!)  }
        })

    }

    val productModel : ProductModel

    init {
        productModel = ProductModel.getInstance()
    }



}