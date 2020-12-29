package com.example.projetandroid4a.domain.usecase

import com.example.projetandroid4a.data.repository.UserRepository
import com.example.projetandroid4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String, pwd: String) : User?{
        return userRepository.getUser(email, pwd)
    }
}