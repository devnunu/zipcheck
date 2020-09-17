package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.checklist.ChecklistDataSource
import com.devnunu.zipcheck.data.checklist.ChecklistRepository
import com.devnunu.zipcheck.data.checklist.DefaultChecklistRepository
import com.devnunu.zipcheck.data.checklist.local.LocalChecklistDataSource
import org.koin.dsl.module

val templateDataModule = module {

    single<ChecklistDataSource> { LocalChecklistDataSource() }

    factory<ChecklistRepository> { DefaultChecklistRepository(get()) }
}