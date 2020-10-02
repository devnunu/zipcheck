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
        houseType = houseType,
        checklist = checklist
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
        houseType = houseType,
        checklist = checklist
    )