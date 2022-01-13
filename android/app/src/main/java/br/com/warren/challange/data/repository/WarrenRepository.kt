package br.com.warren.challange.data.repository

import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.response.LoginBody

open class WarrenRepository(private val api: ServiceApi) {

    suspend fun login(email: String, password: String) =
        api.login(LoginBody(email, password))

    suspend fun listObjectives() = api.listObjectives()
}