package net.bdtech.estate.ui.properties.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.bdtech.estate.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class PropertiesViewPagerModelFactory(val mContext:Context,val fragmentManager: FragmentManager) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PropertiesViewPagerModel(mContext,fragmentManager) as T
    }
}