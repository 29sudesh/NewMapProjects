package net.bdtech.estate.ui.auth

import net.bdtech.estate.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}