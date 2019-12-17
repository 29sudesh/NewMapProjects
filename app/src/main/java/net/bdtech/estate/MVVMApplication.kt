package net.bdtech.estate

import android.app.Application
import net.bdtech.estate.data.db.AppDatabase
import net.bdtech.estate.data.network.MyApi
import net.bdtech.estate.data.network.NetworkConnectionInterceptor
import net.bdtech.estate.data.preferences.PreferenceProvider
import net.bdtech.estate.data.repositories.QuotesRepository
import net.bdtech.estate.data.repositories.UserRepository
import net.bdtech.estate.ui.auth.AuthViewModelFactory
import net.bdtech.estate.ui.home.profile.ProfileViewModelFactory
import net.bdtech.estate.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider{ QuotesViewModelFactory(instance())}


    }

}