package com.devnunu.zipcheck.di.data

import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import org.koin.dsl.module

val templateDataModule = module {
    single { TemplateRepository() }
}