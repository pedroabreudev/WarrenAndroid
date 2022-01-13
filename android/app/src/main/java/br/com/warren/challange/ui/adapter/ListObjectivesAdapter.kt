package br.com.warren.challange.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.warren.challange.data.response.ListObjectivesResponse
import br.com.warren.challange.data.response.ObjectiveResponse
import br.com.warren.challange.databinding.ItemObjectiveBinding
import com.squareup.picasso.Picasso

class ListObjectivesAdapter(objectivesAdapter: ListObjectivesResponse) :
    RecyclerView.Adapter<ListObjectivesAdapter.ObjectivesViewHolder>() {

    inner class ObjectivesViewHolder(val binding: ItemObjectiveBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var objectives: List<ObjectiveResponse> = objectivesAdapter.portfolios

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
            tvTitleObjective.text = objective.name
            Picasso.get().load(objective.background.thumb).into(ivObjective)
        }
    }

    override fun getItemCount() = objectives.size
}