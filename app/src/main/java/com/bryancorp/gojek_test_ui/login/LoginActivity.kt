package com.bryancorp.gojek_test_ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bryancorp.gojek_test_ui.MainActivity
import com.bryancorp.gojek_test_ui.databinding.ActivityLoginBinding
import com.bryancorp.gojek_test_ui.databinding.ActivityMainBinding
import com.bryancorp.gojek_test_ui.helper.Constant
import com.bryancorp.gojek_test_ui.helper.PreferenceHelper
import com.bryancorp.gojek_test_ui.register.RegisterActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = PreferenceHelper(this)

        binding.btnLogin.setOnClickListener {
            val sharedEmail = sharedPref.getString(Constant.PREF_EMAIL)
            val sharedPassword = sharedPref.getString(Constant.PREF_PASSWORD)
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()

            if (email.contains(sharedEmail.toString()) || password.contains(sharedPassword.toString()))
            {
                sharedPref.put(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_LONG).show()
                intentTo(MainActivity::class.java)
                finish()
            } else {
                Snackbar.make(binding.root, "Terdapat Kesalahan Pada Input Text", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnSignUp.setOnClickListener {
            intentTo(RegisterActivity::class.java)
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            intentTo(MainActivity::class.java)
        }
    }

    private fun intentTo(classs: Class<*>){
        val intent = Intent(this, classs)
        startActivity(intent)
    }
}