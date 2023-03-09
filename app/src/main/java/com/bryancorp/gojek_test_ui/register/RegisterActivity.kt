package com.bryancorp.gojek_test_ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bryancorp.gojek_test_ui.databinding.ActivityRegisterBinding
import com.bryancorp.gojek_test_ui.helper.Constant
import com.bryancorp.gojek_test_ui.helper.PreferenceHelper
import com.bryancorp.gojek_test_ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = PreferenceHelper(this)

        binding.apply {
            btnDiaSubmit.setOnClickListener {
                val username = etUsername.text
                val email = etEmail.text
                val number = etNumber.text
                val password = etPassword.text

                if (username.isNullOrEmpty() && email.isNullOrEmpty() && password.isNullOrEmpty()){
                    Toast.makeText(applicationContext, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
                } else {
                    sharedPref.put(Constant.PREF_USERNAME, username.toString())
                    sharedPref.put(Constant.PREF_EMAIL, email.toString())
                    sharedPref.put(Constant.PREF_PASSWORD, password.toString())
                    sharedPref.put(Constant.PREF_NUMBER, number.toString())
                    Toast.makeText(applicationContext, "Registrasi Berhasil", Toast.LENGTH_LONG).show()
                    intentTo(LoginActivity::class.java)
                }
            }
        }
    }


    private fun intentTo(classs: Class<*>){
        val intent = Intent(this, classs)
        startActivity(intent)
    }
}