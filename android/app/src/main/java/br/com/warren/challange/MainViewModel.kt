package br.com.warren.challange

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.warren.challange.repository.WarrenRepository
import br.com.warren.challange.response.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: WarrenRepository) : ViewModel() {

    private val _loginResponse: MutableLiveData<Response<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Response<LoginResponse>>
        get() = _loginResponse

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }
}