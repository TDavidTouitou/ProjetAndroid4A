package com.example.projetandroid4a.presentation.createAccount

sealed class LoginExist

data class LoginAlreadyExist(val email: String) : LoginExist()
object LoginNotExist : LoginExist()