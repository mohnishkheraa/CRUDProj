package com.ltts.loginwithcrudoperation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.ltts.loginwithcrudoperation.Database.Logreg_DB
import com.ltts.loginwithcrudoperation.Registration.Reg
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        var et_name: AppCompatEditText?=null;
        var et_email: AppCompatEditText?=null;
        var et_mobile: AppCompatEditText?=null;
        var et_password: AppCompatEditText?=null;
        var checkbox: CheckBox?=null;
        var signup: ImageButton?=null;
        var signin: Button?=null;
        var emailPatter: Pattern?=null;
        var mobilePatter:Pattern?=null;
        buttonRego.setOnClickListener {
            var name=editTextName?.text.toString().trim()
            var email=editTextEmail?.text.toString().trim()
            var mobile=editTextPhone?.text.toString().trim()
            var pass=editTextPassword?.text.toString().trim()
            var registration: Reg = Reg(name,email,pass,mobile)
            if(name.length<=0)
            {
                Toast.makeText(applicationContext,"Please Enter Name",Toast.LENGTH_SHORT).show()

            }
            if(email.length<=0)
            {
                Toast.makeText(applicationContext,"Please Enter Email",Toast.LENGTH_SHORT).show()

            }
            if(mobile.length<=0)
            {
                Toast.makeText(applicationContext,"Please Enter Mobile",Toast.LENGTH_SHORT).show()

            }
            if(pass.length<=0)
            {
                Toast.makeText(applicationContext,"Please Enter Password",Toast.LENGTH_SHORT).show()

            }
            if(!(emailPatter?.matcher(email)?.find())!!)
            {
                Toast.makeText(applicationContext,"Please Enter valid email",Toast.LENGTH_SHORT).show()

            }
            if(!(mobilePatter?.matcher(mobile)?.find())!!)
            {
                Toast.makeText(applicationContext,"Please Enter valid mobile number",Toast.LENGTH_SHORT).show()

            }
            var list= Logreg_DB.getInstance(applicationContext).registrationDAO().checkLogin(email,pass) as List;
            if(list.size===0)
            {
                Logreg_DB.getInstance(applicationContext).registrationDAO().insert(registration);
                Toast.makeText(applicationContext,"user registered successfuly",Toast.LENGTH_SHORT).show()
                callSignIn()

            }else
            {
                Toast.makeText(applicationContext,"user already exist with this email Id",Toast.LENGTH_SHORT).show()
            }


        }

    }
    override fun onBackPressed() {
        callSignIn()
    }

    private fun callSignIn()
    {
        Toast.makeText(applicationContext,"Registration Successful",Toast.LENGTH_SHORT).show()
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
