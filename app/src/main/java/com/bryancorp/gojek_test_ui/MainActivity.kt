package com.bryancorp.gojek_test_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.bryancorp.gojek_test_ui.databinding.ActivityMainBinding
import com.bryancorp.gojek_test_ui.profile.ProfileActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initHomeFragment()

//        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.avatarUser.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initHomeFragment() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fl_main, homeFragment).commit()
    }
}