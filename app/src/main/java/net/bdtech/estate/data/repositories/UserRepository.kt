package net.bdtech.estate.data.repositories

import net.bdtech.estate.data.db.AppDatabase
import net.bdtech.estate.data.db.entities.User
import net.bdtech.estate.data.network.MyApi
import net.bdtech.estate.data.network.SafeApiRequest
import net.bdtech.estate.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}