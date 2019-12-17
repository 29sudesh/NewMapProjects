package net.bdtech.estate.ui.properties.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.bdtech.estate.R
import net.bdtech.estate.ui.properties.adapters.PagerAdapter
import net.bdtech.estate.ui.properties.fragments.PageOneFragment
import net.bdtech.estate.ui.properties.fragments.PageTwoFragment
import net.bdtech.estate.ui.properties.navigators.ViewPagerNavigator
import net.bdtech.estate.ui.properties.viewmodels.ViewPagerViewModel
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.activity_view_pager.view.*

class ViewPagerFragment : Fragment(), ViewPagerNavigator {
    private val viewModel by lazy {
        ViewPagerViewModel(context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_view_pager,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager(view)
    }

    private fun setViewPager(view: View) {
        val pageOneFragment = PageOneFragment.newInstance().apply {
            setViewModel(viewModel)
        }

        val pageTwoFragment = PageTwoFragment.newInstance().apply {
            setViewModel(viewModel)
        }

        view.ly_view_pager.adapter = PagerAdapter(
            childFragmentManager,
            listOf(pageOneFragment, pageTwoFragment)
        )
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        super.onDestroy()
    }

//    override fun onBackPressed() {
//        if (ly_view_pager.currentItem == 0) {
//            finish()
//        } else {
//            ly_view_pager.setCurrentItem(ly_view_pager.currentItem - 1, true)
//        }
//    }

    override fun toNext() {
        ly_view_pager.setCurrentItem(ly_view_pager.currentItem + 1, true)
    }

    override fun toResult(inputText: String, number: Int) {

    }
}