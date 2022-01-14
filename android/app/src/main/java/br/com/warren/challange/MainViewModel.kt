package br.com.warren.challange

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.warren.challange.data.repository.WarrenRepository
import br.com.warren.challange.data.response.ListObjectivesResponse
import br.com.warren.challange.data.response.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: WarrenRepository) : ViewModel() {

    private val _loginResponse: MutableLiveData<Response<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Response<LoginResponse>>
        get() = _loginResponse

    private val _objectivesResponse: MutableLiveData<Response<ListObjectivesResponse>> = MutableLiveData()
    val objectivesResponse: LiveData<Response<ListObjectivesResponse>>
        get() = _objectivesResponse

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }

    fun listObjectives() = viewModelScope.launch {
        _objectivesResponse.value = repository.listObjectives()
    }
}