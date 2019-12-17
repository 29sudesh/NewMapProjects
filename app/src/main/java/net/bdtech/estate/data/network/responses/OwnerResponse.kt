package net.bdtech.estate.data.network.responses

import net.bdtech.estate.data.db.entities.Owner

data class OwnerResponse (
    val isSuccessful: Boolean,
    val owners: List<Owner>
)