package br.com.warren.challange.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import br.com.warren.challange.MainViewModel
import br.com.warren.challange.R
import br.com.warren.challange.databinding.FragmentHomeBinding
import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.repository.WarrenRepository
import br.com.warren.challange.ui.base.BaseFragment


class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding, WarrenRepository>() {

    private var messageToast = 0
    private val images =
        intArrayOf(R.drawable.home, R.drawable.conta, R.drawable.carteiras, R.drawable.trade)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarouselView()
        openAccount()
        goin()
    }

    private fun goin() {
        binding.btnGoIn.setOnClickListener {
            userPreferences.authToken.asLiveData().observe(viewLifecycleOwner, Observer {
                if (it == null) {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                } else {
                    findNavController().navigate(R.id.action_homeFragment_to_objectivesListFragment)
                }
            })
        }
    }

    private fun openAccount() {
        binding.btnOpenAccount.setOnClickListener {
            messageToast = R.string.function_unavailable
            toastMessage(messageToast)
        }
    }

    private fun initCarouselView() {
        binding.carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(images[position])
        }
        binding.carouselView.pageCount = images.size
    }

    private fun toastMessage(messageToast: Int) {
        Toast.makeText(requireContext(), messageToast, Toast.LENGTH_SHORT).show()
    }

    override fun getViewModel() = MainViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = WarrenRepository(remote.buildApi(ServiceApi::class.java))

}