package com.example.projetandroid4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetandroid4a.R
import com.example.projetandroid4a.domain.entity.User
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        confirm_create_account_button.setOnClickListener(){

            val user = User(createLogin_edit.text.toString().trim(), createPassword_edit.text.toString().trim())
            if ((createPassword_edit.text.toString() == createConfirmPassword_edit.text.toString()) && user.email != ""){
                mainViewModel.onClickedCreateUser(user)
                MaterialAlertDialogBuilder(this)
                    .setTitle("Success")
                    .setMessage("Account created")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
                val myIntent : Intent =  Intent(this,MainActivity::class.java)
                startActivity(myIntent)
            }else{
                MaterialAlertDialogBuilder(this)
                    .setTitle("Erreur")
                    .setMessage("Password Missmatch or bad Login")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }

        }
    }


}
