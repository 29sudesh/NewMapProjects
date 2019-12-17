package net.bdtech.estate.ui.properties.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view_pager.view.*
import net.bdtech.estate.R
import net.bdtech.estate.databinding.ActivityViewPagerBinding
import net.bdtech.estate.ui.home.profile.ProfileViewModel
import net.bdtech.estate.ui.properties.adapters.MainSectionsAdapter
import net.bdtech.estate.ui.properties.viewmodels.PropertiesViewPagerModel
import net.bdtech.estate.ui.properties.viewmodels.PropertiesViewPagerModelFactory
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ViewPagerFragment : Fragment() {
    private var myView:View? = null
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        if (myView == null){
            myView = inflater.inflate(R.layout.activity_view_pager,container,false)
        }
       return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= MainSectionsAdapter(context!!,childFragmentManager)
        view.pager.adapter = adapter
        view.tab_layout.setupWithViewPager(view.pager,true)

    }
    override fun onDestroy() {
        super.onDestroy()
    }
}