package br.com.warren.challange.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")

class UserPreferences(context: Context) {

    private val appContext = context.applicationContext

    val authToken: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    suspend fun saveAccessToken(authToken: String) {
        appContext.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = authToken
        }
    }

    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("key_access_token")
    }


}