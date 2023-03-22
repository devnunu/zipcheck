package com.devnunu.zipcheck.data.model.user

import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId
    val id: String? = null
)