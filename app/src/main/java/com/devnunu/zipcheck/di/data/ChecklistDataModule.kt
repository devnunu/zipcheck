package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.checklist.repo.ChecklistRepository
import org.koin.dsl.module

val templateDataModule = module {
    single { ChecklistRepository() }
}