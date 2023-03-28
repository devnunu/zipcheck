package com.devnunu.zipcheck.api

import com.devnunu.zipcheck.data.model.common.wrapAsResResult
import com.devnunu.zipcheck.data.model.house.House
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

class HouseApi(
    private val fireStore: FirebaseFirestore,
) {
    private val houseCollection = fireStore.collection(COLLECTION_HOUSES)

    suspend fun getAllHouseList(): List<House> =
        houseCollection
            .get()
            .await()
            .map { it.toObject() }

    suspend fun addHouse(house: House): House {
        houseCollection.add(house).await()!!
        return house
    }

    suspend fun updateHouseAlias(
        houseId: String,
        alias: String
    ) {
        houseCollection.document(houseId)
            .update("alias", alias)
            .await()
    }

    suspend fun updateHouse(
        house: House
    ): House {
        val houseRef = houseCollection.document(house.id!!)
        fireStore.runTransaction { transaction ->
            transaction.set(houseRef, house)
        }.await()
        return house
    }

    companion object {
        const val COLLECTION_HOUSES = "houses"
    }
}