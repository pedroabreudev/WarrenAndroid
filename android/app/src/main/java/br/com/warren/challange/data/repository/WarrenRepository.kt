package br.com.warren.challange.data.repository

import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.response.LoginBody

class WarrenRepository(private val api: ServiceApi) : BaseRepository() {

    suspend fun login(email: String, password: String) =
        api.login(LoginBody(email, password))

}