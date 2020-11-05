package com.devnunu.zipcheck.data.house.mapper

import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.model.House

internal fun House.toHouseEntity() =
    HouseEntity(
        id = id,
        name = name,
        description = description,
        favorites = favorites,
        deposit = deposit,
        monthlyPay = monthlyPay,
        memo = memo,
        transactionType = transactionType,
        checklist = checklist,
        area = area,
        floor = floor,
        structure = structure,
        parking = parking,
        elevator = elevator,
        managementFee = managementFee,
        houseType = houseType
    )

internal fun HouseEntity.toHouse() =
    House(
        id = id,
        name = name,
        description = description,
        favorites = favorites,
        deposit = deposit,
        monthlyPay = monthlyPay,
        memo = memo,
        transactionType = transactionType,
        checklist = checklist,
        area = area,
        floor = floor,
        structure = structure,
        parking = parking,
        elevator = elevator,
        managementFee = managementFee,
        houseType = houseType
    )