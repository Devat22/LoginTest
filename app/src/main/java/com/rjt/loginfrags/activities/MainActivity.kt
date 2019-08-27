package com.rjt.loginfrags.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rjt.loginfrags.R
import com.rjt.loginfrags.fragments.HomeFragment
import com.rjt.loginfrags.fragments.LoginFragment
import com.rjt.loginfrags.helpers.SessionManager
import com.rjt.loginfrags.helpers.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        val switch = Switch()
        val session:SessionManager = SessionManager(this)
        if(session.isLoggedIn()){

            val bundle = Bundle()
            bundle.putString("name", session.getName())
            switch.toHome(this, bundle)
        }else{
            switch.toLogin(this)
        }
    }
}
