package com.example.projetandroid4a.presentation.createAccount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid4a.domain.usecase.GetUserIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val getUserIdUseCase: GetUserIdUseCase)
    :ViewModel(){

    val loginLiveData: MutableLiveData<LoginExist> = MutableLiveData()

    fun onClickedConfirm(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserIdUseCase.invoke(emailUser)
            val loginExist = if (user != null){
                LoginAlreadyExist(user.email)
            }else{
                LoginNotExist
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginExist
            }

        }
    }
}