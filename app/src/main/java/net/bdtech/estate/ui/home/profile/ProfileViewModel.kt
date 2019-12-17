package net.bdtech.estate.ui.home.profile

import androidx.lifecycle.ViewModel;
import net.bdtech.estate.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
