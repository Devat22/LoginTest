package com.rjt.loginfrags.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rjt.loginfrags.R
import com.rjt.loginfrags.helpers.SessionManager
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val ARG_PARAM1:String? = "name"
    private var param1:String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)
        val session = SessionManager(this.context!!)
        view.name.append(param1)
        view.logout.setOnClickListener{

            session.logout()
            val fr = LoginFragment()

            val tr = activity?.supportFragmentManager?.beginTransaction()
            tr?.replace(R.id.frc, fr)
            tr?.commit()
        }
        return view
    }


}
