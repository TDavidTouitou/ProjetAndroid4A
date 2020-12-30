package com.example.projetandroid4a.presentation.createAccount

sealed class LoginExist

data class LoginAlreadyExist(val email: String) : LoginExist()
object LoginNotExist : LoginExist()
object PasswordMissmatch : LoginExist()
object NoPassword : LoginExist()
object NoLogin : LoginExist()
object CreateSuccess : LoginExist()