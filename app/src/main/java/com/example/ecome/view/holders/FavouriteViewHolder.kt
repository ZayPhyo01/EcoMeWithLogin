package com.example.ecome.view.holders

import android.view.View
import com.bumptech.glide.Glide
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import kotlinx.android.synthetic.main.item_view_fav.view.*

class FavouriteViewHolder(view: View) : BaseViewHolder<ProductVO>(view) {

    override fun bind(bindData: ProductVO) {
        var imageUrl = bindData.product_image_url[0].image_url
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.ImvFavouritePic)

    }


    override fun onClick(v: View?) {

    }
}