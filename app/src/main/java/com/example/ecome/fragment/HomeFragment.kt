package com.example.ecome.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.activity.DetailProductActivity
import com.example.ecome.adapter.CategoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ICategory
import com.example.ecome.data.model.IProduct
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.mvp.presenter.HomePresenter
import com.example.ecome.mvp.presenter.IHomePresenter
import com.example.ecome.mvp.view.HomeView
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(),HomeView {

    override fun nevigateTo(id : Int) {
        var intent: Intent = DetailProductActivity.newIntent(context!!)
        intent.putExtra(AppUtils.PRODUCT_ID, id)
        context!!.startActivity(intent)
    }

    override fun showCategoryList(categoryList: MutableList<CategoryVO>) {
        setUpCategory(categoryList)
    }

    override fun showProductList(productList: MutableList<ProductVO>) {
        var productListDebug = productList
        setUpProduct(productList)
    }


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    var homePresenter : HomePresenter
    var categoryModel: CategoryModel

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var productAdapter: ProductAdapter

    init {
        categoryModel = CategoryModel.getInstance()

        homePresenter = HomePresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



 /*   override fun onTap(productId: Int) {
        productModel.saveProductHistoryWithId(productId)
        var intent: Intent = DetailProductActivity.newIntent(context!!)
        intent.putExtra(AppUtils.PRODUCT_ID, productId)
        context!!.startActivity(intent)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        categoryAdapter = CategoryAdapter(context!!)
        productAdapter = ProductAdapter(context!!,homePresenter)
        rv_category.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_category.adapter = categoryAdapter

        rv_product.layoutManager = GridLayoutManager(context, 2)
        rv_product.adapter = productAdapter

        homePresenter.onUiReady()
    }



    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.appBarstatusColor));
        }


    }

    /**
     * set up category with catgory data by showing on recyclerview
     * contain category adapter
     */
    fun setUpCategory(categoryList: MutableList<CategoryVO>) {

        categoryAdapter.setNewData(categoryList)

    }

    fun setUpProduct(productList: MutableList<ProductVO>) {

        productAdapter.setNewData(productList)


    }
}