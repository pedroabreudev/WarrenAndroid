package br.com.warren.challange.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.warren.challange.MainViewModel
import br.com.warren.challange.data.repository.WarrenRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: WarrenRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}
