package br.com.warren.challange.data.network

import br.com.warren.challange.data.response.ListObjectivesResponse
import br.com.warren.challange.data.response.LoginBody
import br.com.warren.challange.data.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {

    @POST("account/login")
    suspend fun login(@Body body: LoginBody): Response<LoginResponse>

    @GET("portfolios/mine")
    suspend fun listObjectives(): Response<ListObjectivesResponse>
}