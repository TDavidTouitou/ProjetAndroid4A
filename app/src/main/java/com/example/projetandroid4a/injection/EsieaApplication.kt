package com.example.projetandroid4a.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication : Application(){
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            androidContext(this@EsieaApplication)
            modules(presentationModule)
        }
    }
}