package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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


    lateinit var favPresenter : FavouritePresenter
    lateinit var favouriteAdapter: FavouriteAdapter

    init {

        favouriteAdapter = FavouriteAdapter()
    }

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context,FavouriteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favPresenter = ViewModelProviders.of(this).get(FavouritePresenter::class.java)
        favPresenter.initView(this)
        setContentView(R.layout.activity_favourite)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
              getWindow().setStatusBarColor(ContextCompat.getColor(applicationContext, R.color.whiteStatusBarColor));
             }


        rvFavourite.layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
            2,
            androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
        )
        rvFavourite.adapter = favouriteAdapter


    }

    override fun onStart() {
        super.onStart()
        favPresenter.onUiReady(this)
    }
}