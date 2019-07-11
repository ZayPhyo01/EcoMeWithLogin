package com.example.ecome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.mvp.presenter.HomePresenter
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.ProductViewHolder
import com.example.ecome.viewmodel.HomeViewModel

class ProductAdapter(var mPresenter: HomeViewModel,val tap : (Int) -> Unit) :
    BaseAdapter<ProductViewHolder, ProductVO>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ProductVO> {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_view_product, p0, false)
        return ProductViewHolder(view, mPresenter,tap)
    }

}