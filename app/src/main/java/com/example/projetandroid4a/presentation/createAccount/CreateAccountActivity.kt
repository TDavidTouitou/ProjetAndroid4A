package com.example.projetandroid4a.presentation.createAccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projetandroid4a.R
import com.example.projetandroid4a.domain.entity.User
import com.example.projetandroid4a.presentation.main.MainActivity
import com.example.projetandroid4a.presentation.main.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main2.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()
    val createAccountViewModel : CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        createAccountViewModel.loginLiveData.observe(this, Observer {

            when(it) {
                is LoginAlreadyExist -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oops !")
                        .setMessage("This account already exist")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                CreateSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succes")
                        .setMessage("Account created")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    createLogin_edit.setText("")
                    createPassword_edit.setText("")
                    createConfirmPassword_edit.setText("")
                    //this.finish()
                }
                NoPassword -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oops !")
                        .setMessage("There is no password")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                NoLogin -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oops !")
                        .setMessage("There is no Login")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                PasswordMissmatch -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oops !")
                        .setMessage("Password missmatch")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        confirm_create_account_button.setOnClickListener(){
            createAccountViewModel.onClickedConfirm(createLogin_edit.text.toString().trim(), createPassword_edit.text.toString().trim(),createConfirmPassword_edit.text.toString())
        }
    }
}
