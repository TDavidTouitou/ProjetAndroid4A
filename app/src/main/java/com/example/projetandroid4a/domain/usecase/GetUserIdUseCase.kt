package com.example.projetandroid4a.domain.usecase

import com.example.projetandroid4a.data.repository.UserRepository
import com.example.projetandroid4a.domain.entity.User

class GetUserIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User?{
        return userRepository.getUserId(email)
    }
}