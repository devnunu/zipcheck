package com.devnunu.zipcheck.data.house.mapper

import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.entity.HouseEntity
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType

internal fun House.toHouseEntity(): HouseEntity =
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