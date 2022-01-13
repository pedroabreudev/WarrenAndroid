package br.com.warren.challange.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import br.com.warren.challange.data.UserPreferences
import br.com.warren.challange.data.network.Remote
import br.com.warren.challange.data.repository.WarrenRepository

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding, WR : WarrenRepository> : Fragment() {

    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: VB
    protected lateinit var viewModel: VM
    protected val remote = Remote()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userPreferences = UserPreferences(requireContext())
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun getFragmentRepository(): WR
}