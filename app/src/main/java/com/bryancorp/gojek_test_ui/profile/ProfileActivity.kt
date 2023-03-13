package com.bryancorp.gojek_test_ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bryancorp.gojek_test_ui.MainActivity
import com.bryancorp.gojek_test_ui.databinding.ActivityProfileBinding
import com.bryancorp.gojek_test_ui.helper.Constant
import com.bryancorp.gojek_test_ui.helper.PreferenceHelper
import com.bryancorp.gojek_test_ui.login.LoginActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = PreferenceHelper(this)

        // tv_user.text = sharedPref.getString(Constant.PREF_USERNAME)
        binding.tvName.text = sharedPref.getString(Constant.PREF_USERNAME)
        binding.tvEmail.text = sharedPref.getString(Constant.PREF_EMAIL)
        binding.tvNumber.text = sharedPref.getString(Constant.PREF_NUMBER)

        binding.includeAppbar.ivArrow.setOnClickListener {
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            sharedPref.clear()
            intentTo(ProfileActivity::class.java)
        }
    }

    override fun onStart() {
        super.onStart()
        if (!sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            intentTo(LoginActivity::class.java)
        }
    }

    private fun intentTo(screen: Class<*>){
        val intent = Intent(this, screen)
        startActivity(intent)
    }
}