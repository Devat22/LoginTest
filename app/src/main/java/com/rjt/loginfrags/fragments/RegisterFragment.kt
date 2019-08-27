package com.rjt.loginfrags.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rjt.loginfrags.R
import com.rjt.loginfrags.helpers.SessionManager
import kotlinx.android.synthetic.main.fragment_register.view.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_register, container, false)
        view.register.setOnClickListener{
            val name = view.name.text.toString()
            val email = view.email.text.toString()
            val pass = view.pass.text.toString()
            val session:SessionManager = SessionManager(this.context!!)
            session.register(name,email,pass)
            val fr = LoginFragment()
            val tr = activity?.supportFragmentManager?.beginTransaction()
            tr?.replace(R.id.frc, fr)
            tr?.commit()
        }
        view.loghere.setOnClickListener{
            val fr = LoginFragment()

            val tr = activity?.supportFragmentManager?.beginTransaction()
            tr?.replace(R.id.frc, fr)
            tr?.commit()
        }
        return view
    }


}
