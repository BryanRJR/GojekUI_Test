package com.bryancorp.gojek_test_ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bryancorp.gojek_test_ui.adapter.GofoodAdapter
import com.bryancorp.gojek_test_ui.adapter.NewsAdapter
import com.bryancorp.gojek_test_ui.databinding.FragmentHomeBinding
import com.bryancorp.gojek_test_ui.model.GofoodModel
import com.bryancorp.gojek_test_ui.model.NewsModel
import com.bryancorp.gojek_test_ui.profile.ProfileActivity


class HomeFragment : Fragment() {

    private  var binding: FragmentHomeBinding? = null

    private val newsAdapter = NewsAdapter()

    private val gofoodAdapter = GofoodAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsAdapter.setData(populateData())
        gofoodAdapter.setData(populateDataGofood())

        binding?.rvGofoodHorizontal?.adapter = gofoodAdapter
        binding?.rvNews?.adapter = newsAdapter

        binding?.constraintLayout?.avatarUser?.setOnClickListener {
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

    private fun populateData() : MutableList<NewsModel> {
        val listData = mutableListOf(
            NewsModel(
                image = R.drawable.img_news_1,
                title = " Tahu Cry Yuk, Cipadu",
                descNews = "Sambungin Akun ke Tokopedia, Banyakin Untung"
            ),
            NewsModel(
                image = R.drawable.img_news_2,
                title = "Nasi Goreng ABC",
                descNews = "Sambungin Akun ke Tokopedia, Banyakin Untung"
            ),
            NewsModel(
                image = R.drawable.img_news_3,
                title = "Ayam Geprek Gembus, Cipadu",
                descNews = "Sambungin Akun ke Tokopedia, Banyakin Untung"
            )
        )
        return listData
    }

    private fun populateDataGofood() : MutableList<GofoodModel> {
        val listData = mutableListOf(
            GofoodModel(
                image = R.drawable.promo_1,
                title = " Tahu Cry Yuk, Cipadu"
            ),
            GofoodModel(
                image = R.drawable.promo_2,
                title = "Nasi Goreng ABC"
            ),
            GofoodModel(
                image = R.drawable.promo_3,
                title = "Ayam Geprek Gembus, Cipadu"
            )
        )
        return listData
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}