package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils

class DetailProductActivity : BaseActivity() {

    lateinit var productName: TextView
    lateinit var productPrice: TextView
    lateinit var productImage: ImageView
    lateinit var productDesc: TextView
    lateinit var productModel: ProductModel


    companion object {

        fun newIntent(context: Context): Intent {
            var intent = Intent(context, DetailProductActivity::class.java)
            return intent
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product_activity)

        productModel = ProductModel.getInstance()
        //Init View
        productDesc = findViewById(R.id.tv_detail_product_desc)
        productName = findViewById(R.id.tv_detail_product_name)
        productPrice = findViewById(R.id.tv_detail_product_price)
        productImage = findViewById(R.id.imv_detail_product)


        //Get the id form main activity that cannot be null
        val id: Int = intent.getIntExtra(AppUtils.PRODUCT_ID, -1)
        Log.d(DetailProductActivity.javaClass.toString(), ": product $id ")
        var productVo: ProductVO = productModel!!.getProductsById(id)
        productDesc.setText(productVo.product_desc)
        productPrice.setText(productVo.product_price)
        productName.setText(productVo.product_name)
        var imageUrl = productVo.product_image_url

        if (imageUrl!!.size > 0)
            Glide.with(applicationContext)
                .load(imageUrl[0].image_url)
                .into(productImage)

    }
}