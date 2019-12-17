package net.bdtech.estate.ui.properties.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import net.bdtech.estate.R
import net.bdtech.estate.ui.home.owner.OwnerFragment
import net.bdtech.estate.ui.properties.fragments.PageOneFragment
import net.bdtech.estate.ui.properties.fragments.PageTwoFragment

class MainSectionsAdapter(val mContext:Context, val fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return TABS.size
    }
    override fun getItem(position:Int): Fragment {
        when (TABS[position]) {
            CONTACTS -> return OwnerFragment()
            CALLS -> return OwnerFragment()
            CHATS -> return PageTwoFragment()
        }
        return null!!
    }
    override fun getPageTitle(position:Int):CharSequence {
        when (TABS[position]) {
            CONTACTS -> return mContext.getResources().getString(R.string.contacts)
            CALLS -> return mContext.getResources().getString(R.string.calls)
            CHATS -> return mContext.getResources().getString(R.string.chats)
        }
        return ""
    }
    companion object {
        private val CONTACTS = 0
        private val CALLS = 1
        private val CHATS = 2
        private val TABS = intArrayOf(CONTACTS, CALLS, CHATS)
    }
}