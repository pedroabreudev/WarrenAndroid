package br.com.warren.challange.repository

import br.com.warren.challange.network.ServiceApi
import br.com.warren.challange.response.LoginBody

class WarrenRepository(private val api: ServiceApi) : BaseRepository() {

    suspend fun login(email: String, password: String) =
        api.login(LoginBody(email, password))

}