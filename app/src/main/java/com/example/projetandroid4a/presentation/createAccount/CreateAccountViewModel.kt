package com.example.projetandroid4a.presentation.createAccount

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid4a.domain.entity.User
import com.example.projetandroid4a.domain.usecase.CreateUserUseCase
import com.example.projetandroid4a.domain.usecase.GetUserIdUseCase
import com.example.projetandroid4a.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val createUserUseCase: CreateUserUseCase)
    :ViewModel(){

    val loginLiveData: MutableLiveData<LoginExist> = MutableLiveData()

    fun onClickedConfirm(emailUser: String, pwd: String, confPwd: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserIdUseCase.invoke(emailUser)
            val loginExist = if (user != null){
                LoginAlreadyExist(user.email)
            }else{
                if (emailUser != ""){
                    if ( pwd != ""){
                        if (pwd == confPwd){
                            createUserUseCase.invoke(User(emailUser, pwd))
                            CreateSuccess
                        }else{
                            PasswordMissmatch
                        }
                    }else {
                        NoPassword
                    }
                }else{
                    NoLogin
                }
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginExist
            }

        }
    }
}