package net.bdtech.estate.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import net.bdtech.estate.R
import net.bdtech.estate.data.db.entities.User
import net.bdtech.estate.databinding.ActivityLoginBinding
import net.bdtech.estate.util.hide
import net.bdtech.estate.util.show
import net.bdtech.estate.util.snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fargment_profile)


//        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.fargment_profile)
//        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
//        binding.viewmodel = viewModel
//
//        viewModel.authListener = this
//
//        viewModel.getLoggedInUser().observe(this, Observer { user ->
//            if(user != null){
//                Intent(this, HomeActivity::class.java).also {
//                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    startActivity(it)
//                }
//            }
//        })

    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }

}
