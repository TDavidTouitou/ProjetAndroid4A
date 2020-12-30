package com.example.projetandroid4a.domain.usecase

import com.example.projetandroid4a.data.repository.UserRepository
import com.example.projetandroid4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {

    private val userRepository: UserRepository = mockk()
    private val classUnderTest =GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            //GIVEN
            val email = ""
            val pwd = ""
            coEvery{ userRepository.getUser(email,pwd)}returns null
            //WHEN
            val result = classUnderTest.invoke(email,pwd)

            //THEN
            coVerify(exactly = 1){
                userRepository.getUser(email,pwd)
            }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email`(){
        runBlocking {
            //GIVEN
            val email = "a@a.c"
            val pwd = "a"
            val expectedUser =  User("a@a.c","a")
            coEvery{ userRepository.getUser(email,pwd)}returns expectedUser
            //WHEN
            val result = classUnderTest.invoke(email,pwd)

            //THEN
            coVerify(exactly = 1){
                userRepository.getUser(email,pwd)
            }
            assertEquals(result, expectedUser)
        }
    }

}