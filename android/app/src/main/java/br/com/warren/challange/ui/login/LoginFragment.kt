package br.com.warren.challange.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.warren.challange.MainViewModel
import br.com.warren.challange.R
import br.com.warren.challange.R.string
import br.com.warren.challange.data.network.ServiceApi
import br.com.warren.challange.data.repository.WarrenRepository
import br.com.warren.challange.data.response.LoginResponse
import br.com.warren.challange.databinding.FragmentLoginBinding
import br.com.warren.challange.ui.base.BaseFragment
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginFragment : BaseFragment<MainViewModel, FragmentLoginBinding, WarrenRepository>() {

    private var email = ""
    private var password = ""
    private var messageToast = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forgotPassword()
        clickLogin()
        loginResponse()
    }

    private fun loginResponse() {
        viewModel.loginResponse.observe(viewLifecycleOwner, {
            checkEmailEmpty()
            checkPasswordEmpty()
            checkBodyloginResponse(it)
        })
    }

    private fun clickLogin() {
        binding.btnLogin.setOnClickListener {
            email = binding.etMail.text.toString().trim()
            password = binding.etPassword.text.toString().trim()
            viewModel.login(email, password)
        }
    }

    private fun checkBodyloginResponse(it: Response<LoginResponse>) {
        if (!checkEmailEmpty() && !checkPasswordEmpty() && it.body() == null) {
            messageToast = string.wrong_email_or_password
            toastMessage(messageToast)
        }
        if (it.body() != null) {
            lifecycleScope.launch {
                userPreferences.saveAccessToken(it.body()!!.accessToken)
            }
            findNavController().navigate(R.id.action_loginFragment_to_objectivesListFragment)
        }
    }

    private fun checkEmailEmpty(): Boolean {
        if (email.isEmpty() || email.isBlank()) {
            messageToast = string.empty_email
            toastMessage(messageToast)
            return true
        }
        return false
    }

    private fun checkPasswordEmpty(): Boolean {
        if (password.isEmpty() || password.isBlank()) {
            messageToast = string.empty_password
            toastMessage(messageToast)
            return true
        }
        return false
    }

    private fun forgotPassword() {
        binding.btForgotPassword.setOnClickListener {
            messageToast = string.function_unavailable
            toastMessage(messageToast)
        }
    }

    private fun toastMessage(messageToast: Int) {
        Toast.makeText(requireContext(), messageToast, Toast.LENGTH_SHORT).show()
    }

    override fun getFragmentRepository() = WarrenRepository(remote.buildApi(ServiceApi::class.java))

    override fun getViewModel() = MainViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)
}