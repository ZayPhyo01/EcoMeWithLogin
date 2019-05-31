package com.example.ecome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.FavouriteViewHolder
import kotlinx.android.synthetic.main.activity_main.view.*

class FavouriteAdapter : BaseAdapter<FavouriteViewHolder,ProductVO>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ProductVO> {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.item_view_fav,p0,false)
        return FavouriteViewHolder(view)   }
}