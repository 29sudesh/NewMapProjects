package net.bdtech.estate.ui.home.owner

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.quotes_fragment.*

import net.bdtech.estate.R
import net.bdtech.estate.data.db.entities.Owner
import net.bdtech.estate.util.Coroutines
import net.bdtech.estate.util.hide
import net.bdtech.estate.util.show
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class OwnerFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: OwnerViewModelFactory by instance()

    private lateinit var viewModel: OwnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quotes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(OwnerViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = Coroutines.main {
        progress_bar.show()
        viewModel.quotes.await().observe(this@OwnerFragment, Observer {
            Log.e("DATA : ","  "+Gson().toJson(it))
            progress_bar.hide()
            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(ownerItem: List<OwnerItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(ownerItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }


    private fun List<Owner>.toQuoteItem() : List<OwnerItem>{
        return this.map {
            OwnerItem(it)
        }
    }

}
