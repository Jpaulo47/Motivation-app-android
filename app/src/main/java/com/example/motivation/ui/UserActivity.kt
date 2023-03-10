package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.Key.USER_NAME)
        if (name != ""){
            startActivity(  Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {

        val name = binding.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.Key.USER_NAME, name)

            startActivity( Intent(this, MainActivity::class.java))
            finish()

        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_LONG)
                .show()
        }
    }
}