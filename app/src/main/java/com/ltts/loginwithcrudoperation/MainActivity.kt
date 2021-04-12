package com.ltts.loginwithcrudoperation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ltts.loginwithcrudoperation.Database.Logreg_DB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSubmit.setOnClickListener {
            var emailStr=editTextTextEmailAddress?.text.toString()
            var passStr=editTextTextPassword?.text.toString()
            var list= Logreg_DB.getInstance(applicationContext).registrationDAO().checkLogin(emailStr,passStr) as List;
            if(list.size<=0)
            {
                Toast.makeText(applicationContext,"Invalid Credentials",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Login successful",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,MyRecycler::class.java))
            }

        }
        buttonReg.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }
    }
}