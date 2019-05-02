package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.detail_product_activity.*

class DetailProductActivity : BaseActivity() {


   val productModel: ProductModel

    init {
        productModel = ProductModel.getInstance()
    }


    companion object {

        fun newIntent(context: Context): Intent {
            var intent = Intent(context, DetailProductActivity::class.java)
            return intent
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product_activity)


        //Init View


        //Get the id form main activity that cannot be null
        val id: Int = intent.getIntExtra(AppUtils.PRODUCT_ID, -1)
        Log.d(DetailProductActivity.javaClass.toString(), ": product $id ")
        val productVo: ProductVO = productModel.getProductsById(id)
        tv_detail_product_desc.setText(productVo.product_desc)
        tv_detail_product_price.setText(productVo.product_price)
        tv_detail_product_name.setText(productVo.product_name)
        var imageUrl = productVo.product_image_url

        if (imageUrl!!.size > 0)
            Glide.with(applicationContext)
                .load(imageUrl[0].image_url)
                .into(imv_detail_product)

    }
}