package com.example.ecome.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.ecome.view.holders.BaseViewHolder

abstract class BaseAdapter <T : BaseViewHolder<W>, W : Any>(context: Context) : RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mData: MutableList<W> = ArrayList()
    protected var mLayoutInflator: LayoutInflater

    val items: List<W>
        get() {
            val data = mData
            return data ?: ArrayList()
        }

    init {
        mData = ArrayList()
        mLayoutInflator = LayoutInflater.from(context)
    }


    override fun onBindViewHolder(p0: BaseViewHolder<W>, p1: Int) {
        p0.bind(mData.get(p1))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        mData.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData.size - 1) mData[position] else null

    }

    fun removeData(data: W) {
        mData.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: W) {
        mData.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = ArrayList()
        notifyDataSetChanged()
    }
}
