package com.devnunu.zipcheck.data.checklist.mapper

import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist

internal fun Checklist.toChecklistEntity(): ChecklistEntity =
    ChecklistEntity(
        checklistId = 0,
        name = name,
        items = items
    )

internal fun ChecklistEntity.toChecklist() =
    Checklist(
        id = checklistId,
        name = name,
        items = items
    )