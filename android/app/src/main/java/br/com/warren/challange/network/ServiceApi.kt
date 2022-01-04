package br.com.warren.challange.network

import br.com.warren.challange.response.LoginBody
import br.com.warren.challange.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceApi {

    @POST("account/login")
    suspend fun login(@Body body: LoginBody) : Response<LoginResponse>
}