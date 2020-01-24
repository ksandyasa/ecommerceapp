package com.sehatqtestengineer.features.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sehatqtestengineer.R
import com.sehatqtestengineer.databinding.ContentLoginBinding
import com.sehatqtestengineer.viewmodel.LoginViewModel

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ContentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.content_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.btnSignIn.setOnClickListener {
            val username = binding.edUsername.text.toString()
            val password = binding.edPassword.text.toString()
            viewModel.validateCredentials(username, password).observe(this, object: Observer<String>{

                override fun onChanged(t: String?) {
                    if (t!!.contains("Successful")) {
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                        this@LoginActivity.finish()
                    } else {
                        Toast.makeText(this@LoginActivity, t, Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
    }

}