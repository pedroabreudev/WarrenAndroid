package br.com.warren.challange.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.warren.challange.R
import br.com.warren.challange.databinding.ItemObjectiveBinding

class ListObjectivesAdapter() : RecyclerView.Adapter<ListObjectivesAdapter.ObjectivesViewHolder>() {

    inner class ObjectivesViewHolder(val binding: ItemObjectiveBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val objectives = arrayOf("Porto Alegre", "Florianopolis", "Maceio", "Disney", "Estados Unidos", "Europa", "Nova York")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectivesViewHolder {
        return ObjectivesViewHolder(
            ItemObjectiveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ObjectivesViewHolder, position: Int) {
        val objective = objectives[position]
        holder.binding.apply {
            tvTitleObjective.text = objective
            //todo implementar biblioteca para carregar a imagem.
            ivObjective.setImageResource(R.drawable.home)
        }
    }

    override fun getItemCount() = objectives.size
}