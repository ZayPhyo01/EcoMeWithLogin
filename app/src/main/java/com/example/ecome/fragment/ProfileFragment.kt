package com.example.ecome.fragment

import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.adapter.HistoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import com.example.ecome.mvp.presenter.HistoryPresenter
import com.example.ecome.mvp.view.HistoryView
import com.example.ecome.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.fragement_profile.*

class ProfileFragment : BaseFragment() {
    private fun showUserName(name: String) {
        tvProfileName.setText(name)
    }

    private fun showUserAddress(address: String) {
        tvProfileAddress.setText(address)
          }

    private fun showUserImage(imageUrl: String) {
        Glide.with(context!!)
            .load(imageUrl)
            .into(imvProfile) }

    private fun showHistoryList(products: MutableList<ProductVO>) {
        productAdapter.setNewData(products)
    }

    val historyPresenter: HistoryViewModel
    val productAdapter: HistoryAdapter

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }



    init {

        historyPresenter = HistoryViewModel()
        productAdapter = HistoryAdapter()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.whiteStatusBarColor));
        }

        rvHistory.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        rvHistory.adapter = productAdapter
        historyPresenter.getAllHistory().observe(this,object : Observer<MutableList<ProductVO>>{
            override fun onChanged(t: MutableList<ProductVO>?) {
                showHistoryList(t!!)
            }
        })


    }


    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.whiteStatusBarColor));
        }



    }
}




























