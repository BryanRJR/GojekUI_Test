package com.bryancorp.gojek_test_ui.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bryancorp.gojek_test_ui.R
import com.bryancorp.gojek_test_ui.databinding.ItemsPromosHorizontalBinding
import com.bryancorp.gojek_test_ui.model.PromosNameModel

class PromosNameAdapter: RecyclerView.Adapter<PromosNameAdapter.CategoryFoodViewHolder>() {

    private var data: MutableList<PromosNameModel> = mutableListOf()
    private var onClickList:(PromosNameModel)-> Unit = {}

    fun setData(newData: MutableList<PromosNameModel>) {
        data = newData
        notifyDataSetChanged()
    }

    fun addOnClickFoodCategoryItem(clickFood: (PromosNameModel)->Unit){
        onClickList = clickFood
    }

    inner class CategoryFoodViewHolder(val binding: ItemsPromosHorizontalBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: PromosNameModel) {

            binding.tvTitlePromos.text = data.title
            binding.constPromos.setOnClickListener {
                onClickList(data)
            }

            val(selectedBackgroundRes, selectedColor) = if (data.isSelected ?: false) {
                Pair(R.drawable.background_rounded_selected_green, Color.WHITE)
            } else{
                Pair(R.drawable.background_rounded_outline_black, Color.BLACK)
            }

            val selectedBackground = ContextCompat.getDrawable(binding.root.context, selectedBackgroundRes)

            binding.constPromos.background = selectedBackground
            binding.tvTitlePromos.setTextColor(ColorStateList.valueOf(selectedColor))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFoodViewHolder
            = CategoryFoodViewHolder (
        ItemsPromosHorizontalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(holder: PromosNameAdapter.CategoryFoodViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}