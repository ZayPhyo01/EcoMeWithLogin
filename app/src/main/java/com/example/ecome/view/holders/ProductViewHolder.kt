package com.example.ecome.view.holders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(view: View, var mHomePresenter: HomeViewModel, val tap: (Int) -> Unit) :
    BaseViewHolder<ProductVO>(view) {

    lateinit var productVO: ProductVO

    init {

        val check = itemView.ImvFavourite
        check.setOnClickListener { t ->
            Log.d("Fav in view holder ", "${productVO.isFavourite}")
            if (productVO.isFavourite) {
                mHomePresenter.onTapUnFavourite(productVO.product_id)
            } else {
                mHomePresenter.onTapFavourite(productVO.product_id)
            }
        }


    }


    override fun bind(bindData: ProductVO) {
        productVO = bindData
        Log.d("isFav : ", " ${productVO.isFavourite}")
        var imageUrlDebug = bindData.product_image_url

        if (bindData.product_image_url.size > 0) {
            val imageUrl = bindData.product_image_url[0].image_url
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(itemView.imv_product)
        }

        if (bindData.isFavourite) {
            itemView.ImvFavourite.isChecked = true

        } else {
            itemView.ImvFavourite.isChecked = false
        }
        itemView.tv_product_name.setText(bindData.product_name)
        itemView.tv_product_price.setText(bindData.product_price.toString())
    }

    override fun onClick(v: View?) {
        val id: Int = productVO.product_id
        tap.invoke(id)
        mHomePresenter.onTapItem(id)
        Log.d("ProductView Holder ", id.toString())

    }
}