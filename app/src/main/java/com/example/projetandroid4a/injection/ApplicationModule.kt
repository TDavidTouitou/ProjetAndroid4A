package com.example.projetandroid4a.injection

import com.example.projetandroid4a.MainViewModel
import org.koin.dsl.module


val presentationModule = module {
    factory { MainViewModel() }
}