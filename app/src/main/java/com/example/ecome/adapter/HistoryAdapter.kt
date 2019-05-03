package com.example.ecome.adapter

import android.content.Context
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.ProductHistoryViewHolder

class HistoryAdapter(context: Context, val tap: TapDelegate) :
    BaseAdapter<ProductHistoryViewHolder, ProductVO>(context) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ProductVO> {
        var view = mLayoutInflator.inflate(R.layout.item_view_history, p0, false)
        return ProductHistoryViewHolder(view, tap)
    }
}