package net.bdtech.estate.ui.home.owner

import androidx.lifecycle.ViewModel;
import net.bdtech.estate.data.repositories.OwnerRepository
import net.bdtech.estate.util.lazyDeferred

class OwnerViewModel(
    repository: OwnerRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
