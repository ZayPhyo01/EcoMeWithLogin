package com.example.ecome.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ecome.R
import com.example.ecome.activity.DetailProductActivity
import com.example.ecome.adapter.CategoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils
import com.example.ecome.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment()  {
     var homeViewModel : HomeViewModel = HomeViewModel()



    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    private val categoryAdapter: CategoryAdapter = CategoryAdapter()
    private val productAdapter: ProductAdapter

    init {
        productAdapter = ProductAdapter(homeViewModel,{
            val intent = DetailProductActivity.newIntent(context!!)
            intent.putExtra(AppUtils.PRODUCT_ID,it)
            context!!.startActivity(intent)

        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        rv_category.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context,
            androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
            false
        )
        rv_category.adapter = categoryAdapter

        rv_product.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        rv_product.adapter = productAdapter

       // homeViewModel.onUiReady()
    }



    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.appBarstatusColor));
        }
        homeViewModel.getCategories().observe(this,object : Observer<MutableList<CategoryVO>>{
            override fun onChanged(t: MutableList<CategoryVO>?) {
                 setUpCategory(t!!)
            }
        })
        homeViewModel.getProducts().observe(this,object : Observer<MutableList<ProductVO>>{
            override fun onChanged(t: MutableList<ProductVO>?) {
                Log.d("Product data ","change")
                 setUpProduct(t!!)
            }

        })

    }

    /**
     * set up category with catgory data by showing on recyclerview
     * contain category adapter
     */
    private fun setUpCategory(categoryList: MutableList<CategoryVO>) {

        categoryAdapter.setNewData(categoryList)

    }

    private fun setUpProduct(productList: MutableList<ProductVO>) {

        productAdapter.setNewData(productList)

    }
}