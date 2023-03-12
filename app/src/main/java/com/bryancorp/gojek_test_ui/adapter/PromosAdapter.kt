package com.bryancorp.gojek_test_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bryancorp.gojek_test_ui.databinding.ListPromosBinding
import com.bryancorp.gojek_test_ui.model.PromosModel
import com.bumptech.glide.Glide

class PromosAdapter : RecyclerView.Adapter<PromosAdapter.FoodViewHolder>() {

    private var dataFood: MutableList<PromosModel> = mutableListOf()

    fun setData(newData: MutableList<PromosModel>) {
        dataFood = newData
        notifyDataSetChanged()
    }


    inner class FoodViewHolder(val binding: ListPromosBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: PromosModel) {
//            binding.ivFood.setImageResource(data.image ?: 0)
            Glide.with(binding.root.context)
                .load(data.image)
                .into(binding.ivGofood)
            binding.titleGofood.text = data.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(
            ListPromosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindView(dataFood[position])

    }

    override fun getItemCount(): Int = dataFood.size
}