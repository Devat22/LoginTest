package com.rjt.loginfrags.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rjt.loginfrags.R
import com.rjt.loginfrags.helpers.SessionManager
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_login, container, false)
        view.login.setOnClickListener{
            val session:SessionManager = SessionManager(this.context!!)
            val email = view.email.text.toString()
            val pass = view.pass.text.toString()
            if(session.login(email, pass)){
                val fr = HomeFragment()
                val bundle = Bundle()
                bundle.putString("name", session.sharedPreference.getString("name",""))
                val tr = activity?.supportFragmentManager?.beginTransaction()
                tr?.replace(R.id.frc, fr)
                tr?.commit()
            }else{
                Toast.makeText(this.context,"Wrong credentials",Toast.LENGTH_LONG).show()
            }
        }
        view.reghere.setOnClickListener{
            val fr = RegisterFragment()

            val tr = activity?.supportFragmentManager?.beginTransaction()
            tr?.replace(R.id.frc, fr)
            tr?.commit()
        }
        return view
    }

}
