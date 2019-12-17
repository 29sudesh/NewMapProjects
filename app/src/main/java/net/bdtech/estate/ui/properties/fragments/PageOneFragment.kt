package net.bdtech.estate.ui.properties.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.bdtech.estate.ui.properties.handlers.ViewPagerHandler
import net.bdtech.estate.ui.properties.viewmodels.ViewPagerViewModel
import net.bdtech.estate.R
import net.bdtech.estate.databinding.FragmentViewPager1Binding

class PageOneFragment : Fragment(){

    private var viewModel: ViewPagerViewModel? = null

    private var binding: FragmentViewPager1Binding? = null

    fun setViewModel(viewModel: ViewPagerViewModel){
        this.viewModel = viewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_view_pager_1, container, false)
        if (binding == null) {
            binding = FragmentViewPager1Binding.bind(root)
        }

        binding!!.apply {
            viewmodel = this@PageOneFragment.viewModel
            handlers = ViewPagerHandler()
        }

        return binding!!.root
    }

    companion object {
        fun newInstance(): PageOneFragment = PageOneFragment()
    }
}