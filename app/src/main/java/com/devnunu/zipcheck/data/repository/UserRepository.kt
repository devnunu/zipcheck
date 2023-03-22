package com.devnunu.zipcheck.data.repository

import com.devnunu.zipcheck.common.preference.user.UserPreference
import com.devnunu.zipcheck.data.model.user.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository(
    private val fireStore: FirebaseFirestore,
    private val userPreference: UserPreference
) {

    fun getUser(): User? = userPreference.userId?.let { userId ->
        User(userId)
    }

    suspend fun saveUser(user: User): User =
        fireStore.collection(COLLECTION_USER)
            .add(user)
            .await()
            .let { User(it.id) }

    companion object {
        const val COLLECTION_USER = "users"
    }
}