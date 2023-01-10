package com.flora.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `valid credentials produces success state`() {
        // AAA
        // Arrange
        val viewModel = LoginViewModel()

        // Act
        viewModel.login("kotlin", "rocks")

        // Assert
        Assert.assertEquals(
            LoginViewModelState.Success("23423423"),
            viewModel.stateLiveData.value
        )
    }

    @Test
    fun `invalid credentials produces failure state`() {
        // Arrange
        val viewModel = LoginViewModel()

        // Act
        viewModel.login("fhgfhf", "gjhgjh")

        // Assert
        Assert.assertEquals(
            LoginViewModelState.Failure("Login non valide"),
            viewModel.stateLiveData.value
        )
    }

    // Principe TDD
    // 1. Ecrire le test, run le test => FAIL
    // 2. Ecrire le code
    // 3. run le test => SUCCESS
    @Test
    fun `no input produces disabled button`() {
        val viewModel = LoginViewModel()

        viewModel.updateLogin("", "")

        Assert.assertEquals(
            LoginViewModelState.UpdateLogin(loginButtonEnabled = false),
            viewModel.stateLiveData.value
        )
    }

    @Test
    fun `valid input produces disabled button`() {
        val viewModel = LoginViewModel()

        viewModel.updateLogin("o", "o")

        Assert.assertEquals(
            LoginViewModelState.UpdateLogin(loginButtonEnabled = true),
            viewModel.stateLiveData.value
        )
    }
}