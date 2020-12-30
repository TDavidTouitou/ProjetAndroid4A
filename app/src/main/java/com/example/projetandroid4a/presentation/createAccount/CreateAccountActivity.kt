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

        /*createAccountViewModel.loginLiveData.observe(this, Observer {

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
                LoginNotExist -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succes")
                        .setMessage("Account created")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })*/

        confirm_create_account_button.setOnClickListener(){

            val user = User(createLogin_edit.text.toString().trim(), createPassword_edit.text.toString().trim())

            if ((createPassword_edit.text.toString() == createConfirmPassword_edit.text.toString()) && user.email != "" && user.pwd != ""){
                //createAccountViewModel.onClickedConfirm(user.email)
                mainViewModel.onClickedCreateUser(user)

                MaterialAlertDialogBuilder(this)
                    .setTitle("Success")
                    .setMessage("Account created")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
                createLogin_edit.setText("")
                createPassword_edit.setText("")
                createConfirmPassword_edit.setText("")
                /*val myIntent : Intent =  Intent(this,
                    MainActivity::class.java)
                startActivity(myIntent)*/
            }else{
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Password Missmatch or no Login")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}
