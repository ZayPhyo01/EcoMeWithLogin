package com.example.ecome.view.holders

import android.view.View
import com.bumptech.glide.Glide
import com.example.ecome.data.vos.ProductVO
import kotlinx.android.synthetic.main.item_view_history.view.*

class ProductHistoryViewHolder(view : View) : BaseViewHolder<ProductVO>(view) {
    override fun onClick(v: View?) {

    }

    override fun bind(bindData: ProductVO) {

        Glide.with(itemView.context)
            .load(bindData.product_image_url[0].image_url)
            .into(itemView.imvHistoryPic)

        itemView.tvHistroyCount.setText("${bindData.history_count}")
    }


}