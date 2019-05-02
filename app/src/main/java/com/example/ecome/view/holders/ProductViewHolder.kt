package com.example.ecome.view.holders

import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(view: View, tap: TapDelegate, fav: FavDelegate) : BaseViewHolder<ProductVO>(view, tap) {

    lateinit var productVO: ProductVO
    var favImage: ImageView

    init {
        favImage = itemView.ImvFavourite
        favImage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("productVo id : ", "${productVO.product_id}")
                fav.onTapFav(productVO.product_id)

            }
        })

    }

    

    override fun bind(bindData: ProductVO) {
        productVO = bindData
        var imageUrlDebug = bindData.product_image_url

        if (bindData.product_image_url.size > 0) {
            val imageUrl = bindData.product_image_url[0].image_url
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(itemView.imv_product)
        }
        itemView.tv_product_name.setText(bindData.product_name)
        itemView.tv_product_price.setText(bindData.product_price.toString())
    }

    override fun onClick(v: View?) {
        var id: Int = productVO.product_id
        Log.d("ProductView Holder ", id.toString())
        tap.onTap(id)
    }
}