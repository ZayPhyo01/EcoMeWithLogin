package com.example.ecome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.CategoryViewHolder

class CategoryAdapter() : BaseAdapter<CategoryViewHolder, CategoryVO>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<CategoryVO> {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.item_view_category, p0, false)
        return CategoryViewHolder(view)
    }
}