package com.example.ecome.view.holders

import android.view.View
import com.bumptech.glide.Glide
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.TapDelegate
import kotlinx.android.synthetic.main.item_view_category.view.*

class CategoryViewHolder(view: View, tap: TapDelegate) : BaseViewHolder<CategoryVO>(view, tap) {

    override fun bind(bindData: CategoryVO) {

        Glide.with(itemView.context)
            .load(bindData.category_icon)
            .into(itemView.imv_category_icon)
        itemView.tv_category_name.setText(bindData.category_name.toString())
    }

    override fun onClick(v: View?) {

    }
}