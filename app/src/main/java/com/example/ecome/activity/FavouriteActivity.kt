package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.ecome.R
import com.example.ecome.adapter.FavouriteAdapter
import com.example.ecome.data.model.ProductModel
import com.example.ecome.delegate.TapDelegate
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : BaseActivity() , TapDelegate{
    override fun onTap(productId: Int) {
     }


    var productModel : ProductModel
    lateinit var favouriteAdapter: FavouriteAdapter

    init {
        productModel = ProductModel.getInstance()
    }

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context,FavouriteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        favouriteAdapter = FavouriteAdapter(applicationContext,this)
        var favProduct = productModel.getFavouriteProuduct()
        favouriteAdapter.setNewData(favProduct)
        rvFavourite.layoutManager =  StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvFavourite.adapter = favouriteAdapter

    }
}