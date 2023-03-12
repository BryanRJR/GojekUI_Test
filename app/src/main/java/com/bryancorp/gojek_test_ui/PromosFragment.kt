package com.bryancorp.gojek_test_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bryancorp.gojek_test_ui.adapter.PromosAdapter
import com.bryancorp.gojek_test_ui.adapter.PromosNameAdapter
import com.bryancorp.gojek_test_ui.databinding.FragmentHomeBinding
import com.bryancorp.gojek_test_ui.databinding.FragmentPromosBinding
import com.bryancorp.gojek_test_ui.model.PromosModel
import com.bryancorp.gojek_test_ui.model.PromosNameModel


class PromosFragment : Fragment() {

    private  var binding: FragmentPromosBinding? = null

    private val promosAdapter = PromosAdapter()
    private val promosNameAdapter = PromosNameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPromosBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        promosAdapter.setData(populateData())
        promosNameAdapter.setData(populateDataFoodCategory())

        binding?.rvPromos?.adapter = promosAdapter
        binding?.rvPromosName?.adapter = promosNameAdapter

        promosNameAdapter.addOnClickFoodCategoryItem { categoryFoodModel ->
            val categoryFoodData = populateDataFoodCategory()
            val category = categoryFoodData.map {
                val categoryId = categoryFoodModel.id
                val isSelected = it.id == categoryId
                it.copy(isSelected = isSelected)
            }
            promosNameAdapter.setData(category.toMutableList())

            // filter data category
            val data = populateData()
            val filterData = data.filter { dataFood ->
                dataFood.category == categoryFoodModel.title
            }
            promosAdapter.setData(filterData.toMutableList())
        }
    }

    private fun populateData(): MutableList<PromosModel> {
        val listData = mutableListOf(
            PromosModel(
                image = R.drawable.daging,
                title = "Fat Tony Jakarta",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Daging"
            ),
            PromosModel(
                image = R.drawable.daging_2,
                title = "Poh's Bowl, Bintaro",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Daging"
            ),
            PromosModel(
                image = R.drawable.ikanbakar,
                title = "Ikan Bakar Unik Food, Pondok Indah",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Ikan"
            ),
            PromosModel(
                image = R.drawable.bakso,
                title = "Bakso Malang Cak Endut",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Bakso"
            ),
            PromosModel(
                image = R.drawable.bakmi,
                title = "Bakmi & Seafood 99, Pondok Labu",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Bakmi"
            ),
            PromosModel(
                image = R.drawable.healthy_food,
                title = "The Healthy Habit by DishServe",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Healthy Food"
            ),
        )
        return listData
    }

    private fun populateDataFoodCategory(): MutableList<PromosNameModel> {
        val listData = mutableListOf(
            PromosNameModel(
                id = 1,
                title = "Pedas",
                isSelected = false
            ),
            PromosNameModel(
                id = 2,
                title = "Daging",
                isSelected = false
            ),
            PromosNameModel(
                id = 3,
                title = "Ikan",
                isSelected = false
            ),
            PromosNameModel(
                id = 4,
                title = "Healthy Food",
                isSelected = false
            ),
            PromosNameModel(
                id = 5,
                title = "Sate",
                isSelected = false
            ),
            PromosNameModel(
                id = 6,
                title = "Bakso",
                isSelected = false
            ),
        )
        return listData


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}