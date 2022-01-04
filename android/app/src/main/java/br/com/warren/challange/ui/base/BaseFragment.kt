package br.com.warren.challange.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import br.com.warren.challange.repository.BaseRepository

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding, BR : BaseRepository> : Fragment() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM
    protected val remote = br.com.warren.challange.network.Remote()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun getFragmentRepository(): BR
}