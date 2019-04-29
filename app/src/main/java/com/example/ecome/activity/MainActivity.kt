package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.ecome.R
import com.example.ecome.adapter.CategoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.*
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), TapDelegate {


    // to go details screen

    override fun onTap(productId: Int) {
        val intent = DetailProductActivity.newIntent(applicationContext)
        intent.putExtra(AppUtils.PRODUCT_ID, productId)
        startActivity(intent)

    }


    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent

        }
    }


    var categoryModel: CategoryModel
    var productModel: ProductModel
    var categoryAdapter: CategoryAdapter
    var productAdapter: ProductAdapter
    var userModel: UserModel

    init {
        userModel = UserModel.getInstance()
        productModel = ProductModel.getInstance()
        productAdapter = ProductAdapter(applicationContext, this)
        categoryModel = CategoryModel.getInstance()
        categoryAdapter = CategoryAdapter(context = applicationContext, tap = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitle("Eco Me")



        if (!userModel.isUserLogin()) {
            Log.d("user : ", " not login")
            var intent = LoginActivity.newIntent(applicationContext)
            startActivity(intent)

        }
        Log.d("user", "login")

        bottomAppBar.replaceMenu(R.menu.nav)


        //For category list
        var layoutManager: LinearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager

        rv_category.adapter = categoryAdapter

        //For product list

        var productlayoutManger: GridLayoutManager = GridLayoutManager(applicationContext, 2)
        rv_product.layoutManager = productlayoutManger

        rv_product.adapter = productAdapter


        var categoryFromDb: MutableList<CategoryVO> = categoryModel.getCategoryList(object : ICategory.CategoryResult {
            override fun onError(message: String) {

            }

            override fun onSuccess(categories: MutableList<CategoryVO>) {
                val categoryResult = categories
                categoryAdapter.setNewData(categoryResult)
            }
        })

        if (!categoryModel.isEmpty()) {
            categoryAdapter.setNewData(categoryFromDb)
        }


        var products: MutableList<ProductVO> = productModel.getProducts(object : IProduct.ProductDelegate {
            override fun onSuccess(products: MutableList<ProductVO>) {
                var products = products
                productAdapter.setNewData(products)
            }

            override fun onError(message: String) {

            }
        })

        if (!productModel.isEmpty()) {
            productAdapter.setNewData(products)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.d("Menu id :", "${item!!.itemId}")
        when (item!!.itemId) {
            R.id.profile -> startActivity(ProfileActivity.newIntent(context = applicationContext))
            R.id.home -> startActivity(MainActivity.newIntent(applicationContext))

        }
        return super.onOptionsItemSelected(item)
    }

}
