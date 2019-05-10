package com.example.ecome.view.holders

import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(view: View,var mHomePresenter: HomePresenter) : BaseViewHolder<ProductVO>(view) {


    lateinit var productVO: ProductVO
    var favImage: ImageView

    init {
        favImage = itemView.ImvFavourite
        favImage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("productVo id : ", "${productVO.product_id}")

                if(productVO.isFavourite) {
                    itemView.ImvFavourite.setImageResource(R.drawable.non_fav)
                    mHomePresenter.onTapUnFav(productVO.product_id)
                }else {
                    itemView.ImvFavourite.setImageResource(R.drawable.fav)
                    mHomePresenter.onTapFav(productVO.product_id)
                }

            }
        })

    }

    override fun bind(bindData: ProductVO) {
        productVO = bindData
        Log.d("isFav : "," ${productVO.isFavourite}")
        var imageUrlDebug = bindData.product_image_url

        if (bindData.product_image_url.size > 0) {
            val imageUrl = bindData.product_image_url[0].image_url
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(itemView.imv_product)
        }

        if(bindData.isFavourite){
            itemView.ImvFavourite.setImageResource(R.drawable.fav)
        } else {
            itemView.ImvFavourite.setImageResource(R.drawable.non_fav)
        }
        itemView.tv_product_name.setText(bindData.product_name)
        itemView.tv_product_price.setText(bindData.product_price.toString())
    }

    override fun onClick(v: View?) {
        var id: Int = productVO.product_id
        mHomePresenter.onTapItem(id)
        Log.d("ProductView Holder ", id.toString())

    }
}