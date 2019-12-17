package net.bdtech.estate.ui.home.owner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.bdtech.estate.data.repositories.OwnerRepository

@Suppress("UNCHECKED_CAST")
class OwnerViewModelFactory(
    private val repository: OwnerRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OwnerViewModel(repository) as T
    }
}