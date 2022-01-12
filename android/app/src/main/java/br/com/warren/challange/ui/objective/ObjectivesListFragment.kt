package br.com.warren.challange.ui.objective

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.warren.challange.MainViewModel
import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.repository.WarrenRepository
import br.com.warren.challange.databinding.FragmentObjectivesListBinding
import br.com.warren.challange.ui.adapter.ListObjectivesAdapter
import br.com.warren.challange.ui.base.BaseFragment

class ObjectivesListFragment :
    BaseFragment<MainViewModel, FragmentObjectivesListBinding, WarrenRepository>() {

    private val listObjectivesAdapter by lazy { ListObjectivesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }

    private fun setupRecyclerView() = with(binding) {
        rvListObjectives.apply {
            adapter = listObjectivesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun getViewModel() = MainViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentObjectivesListBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = WarrenRepository(remote.buildApi(ServiceApi::class.java))
}