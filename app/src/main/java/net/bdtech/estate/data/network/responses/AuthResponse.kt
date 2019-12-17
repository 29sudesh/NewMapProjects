package net.bdtech.estate.data.network.responses

import net.bdtech.estate.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)