package com.example.ecome.fragment

import android.content.Intent
import android.os.Bundle
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
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), FavDelegate, TapDelegate {


    companion object {
              fun newInstance(): HomeFragment {
                  return HomeFragment()
              }
          }

    var categoryModel: CategoryModel
    var productModel: ProductModel
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var productAdapter: ProductAdapter

    init {
        categoryModel = CategoryModel.getInstance()
        productModel = ProductModel.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onTapFav(productId: Int) {
        productModel.favouriteWithId(productId)
    }

    override fun onTap(productId: Int) {

        productModel.saveProductHistoryWithId(productId)

        var intent: Intent = DetailProductActivity.newIntent(context!!)
        intent.putExtra(AppUtils.PRODUCT_ID, productId)
        context!!.startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryAdapter = CategoryAdapter(context!!, this)
        productAdapter = ProductAdapter(context!!, this, this)

        //set up for category data
        setUpCategory()
        setUpProduct()


    }

    /**
     * set up category with catgory data by showing on recyclerview
     * contain category adapter
     */
    fun setUpCategory() {
        rv_category.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_category.adapter = categoryAdapter
       var categoryData = categoryModel.getCategoryList(object : ICategory.CategoryResult {
            override fun onSuccess(categories: MutableList<CategoryVO>) {
                categoryAdapter.setNewData(categories)
            }

            override fun onError(message: String) {

            }
        })

        if(categoryData!=null) {
            categoryAdapter.setNewData(categoryData)
        }
    }

    fun setUpProduct() {
        rv_product.layoutManager = GridLayoutManager(context, 2)
        rv_product.adapter = productAdapter
        var productData = productModel.getProducts(object : IProduct.ProductDelegate {
            override fun onError(message: String) {

            }

            override fun onSuccess(products: MutableList<ProductVO>) {
                productAdapter.setNewData(products)
            }
        })
        if(productData!=null) {
            productAdapter.setNewData(productData)
        }
    }
}