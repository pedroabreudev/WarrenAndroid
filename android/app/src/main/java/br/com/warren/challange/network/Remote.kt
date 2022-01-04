package br.com.warren.challange.network

import br.com.warren.challange.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {

    companion object {
        private const val BASE_URL = "https://enigmatic-bayou-48219.herokuapp.com/api/v2/"
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    if (BuildConfig.DEBUG) {
                        val loggin = HttpLoggingInterceptor()
                        loggin.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(loggin)
                    }
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}