package net.bdtech.estate.ui.properties.viewmodels

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import net.bdtech.estate.R
import net.bdtech.estate.ui.properties.extensions.logOutput
import net.bdtech.estate.ui.properties.navigators.ViewPagerNavigator
import net.bdtech.estate.ui.properties.util.convertNumberToText
import net.bdtech.estate.ui.properties.util.selected1
import net.bdtech.estate.ui.properties.util.selected2
import java.lang.Exception

class ViewPagerViewModel(private val context: Context) : BaseObservable() {

    private var navigator: ViewPagerNavigator? = null

    val inputText = ObservableField<String>()

    fun setNavigator(navigator: ViewPagerNavigator) {
        this.navigator = navigator
    }

    fun onClickToNext() {
        logOutput("inputText is ${inputText.get()}")
        if (inputText.get()?.isNotEmpty() == true) {
            navigator?.toNext()
        } else {
            showEmptyError()
        }
    }

    private fun showEmptyError() {
        val dialog = AlertDialog.Builder(context)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setTitle("Empty Error")
            .setMessage("Please input text")
            .let {
                it.create()
            }

        dialog.show()
    }

    fun onClickToResult(@IdRes selectRadioID: Int) {
        val number = when(selectRadioID){
            R.id.rg_view_pager_group_1 -> selected1
            R.id.rg_view_pager_group_2 -> selected2
            else -> throw Exception()
        }
        navigator?.toResult(inputText.get()!!, number)
    }

    fun getRadioText(number: Int): String{
        return context.convertNumberToText(number)
    }

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }
}