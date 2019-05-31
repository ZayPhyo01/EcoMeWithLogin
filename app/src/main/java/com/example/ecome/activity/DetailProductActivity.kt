package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.presenter.DetailProductPresenter
import com.example.ecome.mvp.view.DetailProductView
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.detail_product_activity.*

class DetailProductActivity : BaseActivity(), DetailProductView {

    override fun showDetailProduct(productVO: ProductVO) {
        tv_detail_product_desc.setText(productVO.product_desc)
        tv_detail_product_price.setText(productVO.product_price)
        tv_detail_product_name.setText(productVO.product_name)
        val imageUrl = productVO.product_image_url

        if (imageUrl.size > 0)
            Glide.with(applicationContext)
                .load(imageUrl[0].image_url)
                .into(imv_detail_product)
    }

 lateinit var  detailProductPresenter: DetailProductPresenter


    companion object {

        fun newIntent(context: Context): Intent {
            var intent = Intent(context, DetailProductActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product_activity)

        detailProductPresenter = ViewModelProviders.of(this).get(DetailProductPresenter::class.java)
        detailProductPresenter.initView(this)

        //Init View


        //Get the id form main activity that cannot be null
        val id: Int = intent.getIntExtra(AppUtils.PRODUCT_ID, -1)
        Log.d(DetailProductActivity.javaClass.toString(), ": product $id ")
        detailProductPresenter.onUiReady(id,this)
    }
    }