package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
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
import com.example.ecome.view.holders.FavouriteViewHolder
import com.example.ecome.viewmodel.FavouriteViewModel
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : BaseActivity() {


    lateinit var favPresenter: FavouriteViewModel
    var favouriteAdapter: FavouriteAdapter

    init {
        favouriteAdapter = FavouriteAdapter()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, FavouriteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favPresenter = ViewModelProviders.of(this).get(FavouriteViewModel::class.java)

        setContentView(R.layout.activity_favourite)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(applicationContext, R.color.whiteStatusBarColor));
        }


        rvFavourite.layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
            2,
            androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
        )
        rvFavourite.adapter = favouriteAdapter
        favPresenter.getFavouriteItem().observe(this, object : Observer<MutableList<ProductVO>> {
            override fun onChanged(t: MutableList<ProductVO>?) {
                favouriteAdapter.setNewData(t!!)
            }
        })


    }


}