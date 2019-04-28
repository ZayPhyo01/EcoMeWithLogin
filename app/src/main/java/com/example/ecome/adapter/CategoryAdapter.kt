package com.example.ecome.adapter

import android.content.Context
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.CategoryViewHolder

class CategoryAdapter(context: Context,var tap : TapDelegate) : BaseAdapter<CategoryViewHolder, CategoryVO>(context) {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<CategoryVO> {
        var view = mLayoutInflator.inflate(R.layout.item_view_category, p0, false)
        return CategoryViewHolder(view,tap)
    }
}