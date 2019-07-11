package com.example.ecome.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ecome.fragment.BaseFragment
import com.example.ecome.fragment.HomeFragment
import com.example.ecome.fragment.ProfileFragment

class HomePagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    val homeFragment = HomeFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {

        val fragment: androidx.fragment.app.Fragment?
        when (p0) {
            0 -> fragment = homeFragment
            1 -> fragment = profileFragment


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