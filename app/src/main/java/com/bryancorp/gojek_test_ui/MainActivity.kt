package com.bryancorp.gojek_test_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bryancorp.gojek_test_ui.databinding.ActivityMainBinding
import com.bryancorp.gojek_test_ui.profile.ProfileActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
        replaceFragment(HomeFragment())
//        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    private fun initBottomNavigation() {
        // set item with menu for bottom navigation and replace fragment base on user click
        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_main_home -> {
                    stopFragment(PromosFragment())
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.menu_main_promos -> {
                    stopFragment(HomeFragment())
                    replaceFragment(PromosFragment())
                    true
                }
                else -> false
            }
        }
    }

    // replace fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }

    // stop fragment
    private fun stopFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commit()
    }


//    private fun initHomeFragment() {
//        val homeFragment = HomeFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.fl_main, homeFragment).commit()
//    }
}