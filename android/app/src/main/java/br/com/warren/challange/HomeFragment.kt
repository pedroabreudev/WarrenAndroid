package br.com.warren.challange

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.warren.challange.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val imagens =
        intArrayOf(R.drawable.home, R.drawable.conta, R.drawable.carteiras, R.drawable.trade)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.carouselView.pageCount = imagens.size
        binding.carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(imagens[position])
        }

        binding.btnOpenAccount.setOnClickListener {
            Toast.makeText(context, R.string.function_unavailable, Toast.LENGTH_SHORT).show()
        }

        binding.btnLogin.setOnClickListener {
            Toast.makeText(context, R.string.function_unavailable, Toast.LENGTH_SHORT).show()
        }
    }
}