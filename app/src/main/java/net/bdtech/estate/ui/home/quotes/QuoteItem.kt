package net.bdtech.estate.ui.home.quotes

import com.xwray.groupie.databinding.BindableItem
import net.bdtech.estate.R
import net.bdtech.estate.data.db.entities.Quote
import net.bdtech.estate.databinding.ItemQuoteBinding

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}