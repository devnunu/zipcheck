package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.checklist.ChecklistDataSource
import com.devnunu.zipcheck.data.checklist.ChecklistRepository
import com.devnunu.zipcheck.data.checklist.DefaultChecklistRepository
import com.devnunu.zipcheck.data.checklist.local.LocalChecklistDataSource
import org.koin.dsl.module

val checklistDataModule = module {

    factory<ChecklistDataSource> { LocalChecklistDataSource(get()) }

    factory<ChecklistRepository> { DefaultChecklistRepository(get()) }
}