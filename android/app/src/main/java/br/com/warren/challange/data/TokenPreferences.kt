package br.com.warren.challange.data

import android.content.Context

class TokenPreferences(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("warren", Context.MODE_PRIVATE)

    fun saveToken(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getToken(key: String): String {
        return mSharedPreferences.getString(key, "") ?: ""
    }
}