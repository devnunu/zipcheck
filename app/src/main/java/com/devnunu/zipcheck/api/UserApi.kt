package com.devnunu.zipcheck.api

import com.devnunu.zipcheck.data.model.user.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserApi(
    private val fireStore: FirebaseFirestore,
) {

    suspend fun saveUser(user: User): User =
        fireStore.collection(COLLECTION_USER)
            .add(user)
            .await()
            .let { User(it.id) }

    companion object {
        const val COLLECTION_USER = "users"
    }
}