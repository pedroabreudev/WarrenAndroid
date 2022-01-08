package br.com.warren.challange.ui.objective

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.warren.challange.R
import br.com.warren.challange.databinding.FragmentObjectivesListBinding


class ObjectivesListFragment : Fragment(R.layout.fragment_objectives_list) {

    private lateinit var binding: FragmentObjectivesListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentObjectivesListBinding.bind(view)
    }

}