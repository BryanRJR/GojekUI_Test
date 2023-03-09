package com.bryancorp.gojek_test_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bryancorp.gojek_test_ui.databinding.ListNewsBinding
import com.bryancorp.gojek_test_ui.model.NewsModel

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var dataNews: MutableList<NewsModel> = mutableListOf()
    private var onClickNews: (NewsModel) -> Unit = {}


    fun setData(newData: MutableList<NewsModel>) {
        dataNews = newData
        notifyDataSetChanged()
    }


    fun addOnClickNews(clickNews: (NewsModel) -> Unit) {
        onClickNews = clickNews
    }

    inner class NewsViewHolder(val binding: ListNewsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: NewsModel, onClickNews: (NewsModel) -> Unit) {
            binding.imgNews.setImageResource(data.image ?: 0)
            binding.tvTitle.text = data.title
            binding.tvDescription.text = data.descNews

            binding.itemNews.setOnClickListener {
                onClickNews(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ListNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(dataNews[position], onClickNews)

    }

    override fun getItemCount(): Int = dataNews.size
}