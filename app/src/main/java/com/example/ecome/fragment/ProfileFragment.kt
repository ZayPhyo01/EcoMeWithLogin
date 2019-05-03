package com.example.ecome.fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.adapter.HistoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.delegate.FavDelegate
import com.example.ecome.delegate.TapDelegate
import kotlinx.android.synthetic.main.fragement_profile.*

class ProfileFragment : BaseFragment(), TapDelegate {
    override fun onTap(productId: Int) {

    }



    lateinit var productAdapter: HistoryAdapter

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    val productModel : ProductModel
    val userModel: UserModel

    init {
        userModel = UserModel.getInstance()
        productModel = ProductModel.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.whiteStatusBarColor));
        }

        Glide.with(context!!)
            .load(userModel.getUserProfile())
            .into(imvProfile)
        tvProfileName.setText(userModel.getUserProfile().name)
        tvProfileAddress.setText(userModel.getUserProfile().address)
        rvHistory.layoutManager = GridLayoutManager(context, 2)
        productAdapter = HistoryAdapter(context!!, this )
        rvHistory.adapter = productAdapter



    }

    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                   activity!!.getWindow().setStatusBarColor(ContextCompat.getColor(context!!, R.color.whiteStatusBarColor));
               }

        var history = productModel.getProcuctHistory()
                productAdapter.setNewData( history )
    }
}