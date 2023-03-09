package com.bryancorp.gojek_test_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bryancorp.gojek_test_ui.databinding.ListGofoodBinding
import com.bryancorp.gojek_test_ui.databinding.ListNewsBinding
import com.bryancorp.gojek_test_ui.model.GofoodModel
import com.bryancorp.gojek_test_ui.model.NewsModel
import com.bumptech.glide.Glide

class GofoodAdapter : RecyclerView.Adapter<GofoodAdapter.GofoodViewHolder>() {

    private var dataGofood: MutableList<GofoodModel> = mutableListOf()
    private var onClickGofood: (GofoodModel) -> Unit = {}

    fun setData(newData: MutableList<GofoodModel>) {
        dataGofood= newData
        notifyDataSetChanged()
    }


    inner class GofoodViewHolder(val binding: ListGofoodBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: GofoodModel, onClickGofood: (GofoodModel) -> Unit) {
            Glide.with(binding.root.context)
                .load(data.image)
                .into(binding.ivGofood)

            binding.titleGofood.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GofoodAdapter.GofoodViewHolder =
        GofoodViewHolder(
            ListGofoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GofoodViewHolder, position: Int) {
        holder.bindView(dataGofood[position], onClickGofood)
    }

    override fun getItemCount(): Int {
        return dataGofood.size
    }
}