package net.bdtech.estate.ui.home.quotes

import androidx.lifecycle.ViewModel;
import net.bdtech.estate.data.repositories.QuotesRepository
import net.bdtech.estate.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
