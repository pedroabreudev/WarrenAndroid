package br.com.warren.challange.ui.objective

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.warren.challange.MainViewModel
import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.repository.WarrenRepository
import br.com.warren.challange.data.response.ListObjectivesResponse
import br.com.warren.challange.databinding.FragmentObjectivesListBinding
import br.com.warren.challange.ui.adapter.ListObjectivesAdapter
import br.com.warren.challange.ui.base.BaseFragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class ObjectivesListFragment :
    BaseFragment<MainViewModel, FragmentObjectivesListBinding, WarrenRepository>() {

    private lateinit var listObjectivesAdapter: ListObjectivesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listObjectives()
        viewModel.objectivesResponse.observe(viewLifecycleOwner, {
            setupRecyclerView(it.body() ?: ListObjectivesResponse(portfolios = mutableListOf()))
        })
    }

    private fun setupRecyclerView(listObjectivesResponse: ListObjectivesResponse) = with(binding) {
        rvListObjectives.apply {
            listObjectivesAdapter = ListObjectivesAdapter(listObjectivesResponse)
            adapter = listObjectivesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun getViewModel() = MainViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentObjectivesListBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): WarrenRepository {
        val accessToken = runBlocking { userPreferences.accessToken.first() }
        return WarrenRepository(remote.buildApi(ServiceApi::class.java, accessToken))
    }
}