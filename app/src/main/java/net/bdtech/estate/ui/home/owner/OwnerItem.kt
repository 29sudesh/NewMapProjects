package net.bdtech.estate.ui.home.owner

import com.xwray.groupie.databinding.BindableItem
import net.bdtech.estate.R
import net.bdtech.estate.data.db.entities.Owner
import net.bdtech.estate.databinding.ItemQuoteBinding

class OwnerItem(
    private val owner: Owner
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(owner)
    }
}