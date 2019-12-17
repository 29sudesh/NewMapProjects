package net.bdtech.estate.ui.properties.handlers

import android.widget.RadioGroup
import net.bdtech.estate.ui.properties.extensions.logOutput
import net.bdtech.estate.ui.properties.viewmodels.ViewPagerViewModel

class ViewPagerHandler {

    fun onClickToNext(viewModel: ViewPagerViewModel) {
        logOutput("onClickToNext")
        viewModel.onClickToNext()
    }

    fun onClickToResult(viewModel: ViewPagerViewModel, rg: RadioGroup) {
        viewModel.onClickToResult(rg.checkedRadioButtonId)
    }

    fun getRadioText(viewModel: ViewPagerViewModel, number: Int): String {
        return viewModel.getRadioText(number)
    }
}