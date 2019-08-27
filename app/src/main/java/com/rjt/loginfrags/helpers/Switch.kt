package com.rjt.loginfrags.helpers

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.rjt.loginfrags.R
import com.rjt.loginfrags.fragments.HomeFragment
import com.rjt.loginfrags.fragments.LoginFragment
import com.rjt.loginfrags.fragments.RegisterFragment
import kotlinx.android.synthetic.main.activity_main.view.*

class Switch {
    private var transaction:FragmentTransaction? = null
    private var bundle:Bundle? = null
    public fun toLogin(activity:FragmentActivity){
        val fragment = LoginFragment()
        transaction = activity.supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.frc,fragment!!)
        transaction?.commit()
    }
    public fun toRegister(activity:FragmentActivity){
        val fragment = RegisterFragment()
        transaction = activity.supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.frc,fragment)
        transaction?.commit()
    }
    public fun toHome(activity:FragmentActivity, bundle:Bundle){
        val fragment = HomeFragment()
        fragment.arguments = bundle
        transaction = activity.supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.frc,fragment)
        transaction?.commit()
    }
}