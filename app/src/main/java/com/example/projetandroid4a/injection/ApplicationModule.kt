package com.example.projetandroid4a.injection

import android.content.Context
import androidx.room.Room
import com.example.projetandroid4a.data.local.AppDatabase
import com.example.projetandroid4a.data.local.DatabaseDao
import com.example.projetandroid4a.data.repository.UserRepository
import com.example.projetandroid4a.domain.usecase.CreateUserUseCase
import com.example.projetandroid4a.domain.usecase.GetUserIdUseCase
import com.example.projetandroid4a.domain.usecase.GetUserUseCase
import com.example.projetandroid4a.presentation.createAccount.CreateAccountViewModel
import com.example.projetandroid4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val presentationModule = module {
    factory { MainViewModel(get(), get()) }
    factory { CreateAccountViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetUserIdUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDataBase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDataBase.databaseDao()

}
