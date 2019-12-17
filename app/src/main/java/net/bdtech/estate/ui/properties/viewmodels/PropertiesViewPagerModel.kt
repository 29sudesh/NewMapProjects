package net.bdtech.estate.ui.properties.viewmodels

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import net.bdtech.estate.data.repositories.UserRepository
import net.bdtech.estate.ui.properties.adapters.MainSectionsAdapter

class PropertiesViewPagerModel(val mContext: Context,val fragmentManager :FragmentManager): ViewModel() {

    @BindingAdapter("bind:handler")
    fun bindViewPagerAdapter(view:ViewPager, activity:Context) {
        val adapter = MainSectionsAdapter(view.context!!, fragmentManager)
        view.setAdapter(adapter)
    }
    @BindingAdapter("bind:pager")
    fun bindViewPagerTabs(view: TabLayout, pagerView: ViewPager) {
        view.setupWithViewPager(pagerView, true)
    }
}
