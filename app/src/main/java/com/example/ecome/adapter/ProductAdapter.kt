package com.example.ecome.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.ProductViewHolder

class ProductAdapter (context : Context,var tap : TapDelegate): BaseAdapter<ProductViewHolder,ProductVO>(context){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ProductVO> {
       val view : View =mLayoutInflator.inflate(R.layout.item_view_product,p0,false)
        return ProductViewHolder(view,tap)
    }
}