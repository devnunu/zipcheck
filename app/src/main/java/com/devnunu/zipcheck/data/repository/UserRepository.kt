package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.api.UserApi
import com.devnunu.zipcheck.common.preference.user.UserPreference
import com.devnunu.zipcheck.data.model.common.ResResult
import com.devnunu.zipcheck.data.model.common.wrapAsResResult
import com.devnunu.zipcheck.data.model.user.User

class UserRepository(
    private val userApi: UserApi,
    private val userPreference: UserPreference
) {

    fun getUser(): User? = userPreference.userId?.let { userId ->
        User(userId)
    }

    suspend fun saveUser(user: User): ResResult<User> = wrapAsResResult {
        val user = userApi.saveUser(user)
        userPreference.userId = user.id
        user
    }
}