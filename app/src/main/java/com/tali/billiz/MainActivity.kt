package com.tali.billiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tali.billiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        override fun onResume() {
            super.onResume()
            binding.tvLogin.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
            binding.tvLogin.setOnClickListener {
                clearErrors()
                validatelogin()
            }
        }

        fun validatelogin() {
            val firstName = binding.etUsername.text.toString()
            val lastName = binding.etphoneno.text.toString()
            val email = binding.etemail.text.toString()
            val password = binding.etPassword.text.toString()
            var error = false

            if (firstName.isBlank()) {
                binding.tilUsername.error = "Username is required"
                error = true
            }
            if (lastName.isBlank()) {
                binding.tilphonenumber.error = "Phonenumber is required"
                error = true
            }
            if (email.isBlank()) {
                binding.tilemail.error = "Email is required"
                error = true
            }
            if (password.isBlank()) {
                binding.tilPassword.error = "Password is required"
                error = true
            }
//
            if (!error) {
                Toast.makeText(
                    this,
                    " Hello $firstName registration was successful ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        fun clearErrors() {
            binding.tilUsername.error = null
            binding.tilphonenumber.error = null
            binding.tilemail.error = null
            binding.tilPassword.error = null
        }
    }
