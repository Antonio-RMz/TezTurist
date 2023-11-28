package com.example.tezturist.fragmentsPrincipales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.tezturist.R


class FragmentUno : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uno, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentUno().apply {
                arguments = Bundle().apply {

                }
            }
    }


    //Metetodo creado por mi jiji este esta usando el boton de del fragmento uno (inicio) para pasar a un activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b1 = view.findViewById<Button>(R.id.btnVerMasAtoluca)
        val b2 =view.findViewById<Button>(R.id.btnVerMapaAtoluca)
        b1.setOnClickListener { findNavController(view).navigate(R.id.action_page_inicio_to_activityAtoluca) }
        b2.setOnClickListener { findNavController(view).navigate(R.id.action_page_inicio_to_page_rutas) }


    }




}