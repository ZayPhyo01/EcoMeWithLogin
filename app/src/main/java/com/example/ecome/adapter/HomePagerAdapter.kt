package com.example.ecome.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.ecome.fragment.BaseFragment
import com.example.ecome.fragment.HomeFragment
import com.example.ecome.fragment.ProfileFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(p0: Int): Fragment {

        var fragment: Fragment?
        when (p0) {
            0 -> fragment = HomeFragment.newInstance()
            1 -> fragment = ProfileFragment.newInstance()


            else ->
                fragment = null

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }
    override fun getPageTitle(position: Int): CharSequence? {
            return ""
        }

}