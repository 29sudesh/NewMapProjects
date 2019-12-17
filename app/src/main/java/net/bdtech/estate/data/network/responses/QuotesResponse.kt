package net.bdtech.estate.data.network.responses

import net.bdtech.estate.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)