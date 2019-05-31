package com.example.ecome.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ecome.fragment.BaseFragment
import com.example.ecome.fragment.HomeFragment
import com.example.ecome.fragment.ProfileFragment

class HomePagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {


    override fun getItem(p0: Int): androidx.fragment.app.Fragment {

        var fragment: androidx.fragment.app.Fragment?
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