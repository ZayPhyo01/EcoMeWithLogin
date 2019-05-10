package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.ecome.R
import com.example.ecome.adapter.FavouriteAdapter
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.mvp.presenter.FavouritePresenter
import com.example.ecome.mvp.view.FavouriteView
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : BaseActivity(),FavouriteView {

    override fun showFavoriteList(favouriteProducts: MutableList<ProductVO>) {
        favouriteAdapter.setNewData(favouriteProducts)
    }


    var favPresenter : FavouritePresenter
    lateinit var favouriteAdapter: FavouriteAdapter

    init {
        favPresenter = FavouritePresenter(this)
    }

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context,FavouriteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_favourite)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
              getWindow().setStatusBarColor(ContextCompat.getColor(applicationContext, R.color.whiteStatusBarColor));
             }

        favouriteAdapter = FavouriteAdapter(applicationContext)
        rvFavourite.layoutManager =  StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvFavourite.adapter = favouriteAdapter
        favPresenter.onUiReady()

    }
}