package com.example.ecome.fragment

import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import kotlinx.android.synthetic.main.fragement_profile.*

class ProfileFragment : BaseFragment(), HistoryView {
    override fun showUserName(name: String) {
        tvProfileName.setText(name)
    }

    override fun showUserAddress(address: String) {
        tvProfileAddress.setText(address)
          }

    override fun showUserImage(imageUrl: String) {
        Glide.with(context!!)
            .load(imageUrl)
            .into(imvProfile) }

    override fun showHistoryList(products: MutableList<ProductVO>) {
        productAdapter.setNewData(products)
    }



    val historyPresenter: HistoryPresenter
    val productAdapter: HistoryAdapter

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }



    init {

        historyPresenter = HistoryPresenter()
        historyPresenter.initView(this)
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



    }


    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.whiteStatusBarColor));
        }
        historyPresenter.onUiReady(this)


    }
}




























