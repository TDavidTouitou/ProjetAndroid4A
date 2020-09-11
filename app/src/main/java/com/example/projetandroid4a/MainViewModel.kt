package com.example.projetandroid4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val counter: MutableLiveData<Int> = MutableLiveData()
    val text: MutableLiveData<String> = MutableLiveData()
    init {
        counter.value = 0
    }

    fun onClickedIncrement() {
        counter.value = (counter.value ?: 0) +1
    }
}