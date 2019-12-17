package net.bdtech.estate.ui.properties.viewmodels

import android.content.Context
import androidx.databinding.BaseObservable
import net.bdtech.estate.ui.properties.navigators.TopNavigator

class TopViewModel(private val context: Context): BaseObservable() {

    private var navigator: TopNavigator? = null

    fun setNavigator(navigator: TopNavigator){
        this.navigator = navigator
    }

    fun onClickToViewPager(){
        navigator?.toViewPager()
    }

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }
}