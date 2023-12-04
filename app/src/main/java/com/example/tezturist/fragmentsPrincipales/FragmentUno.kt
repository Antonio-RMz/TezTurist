package com.example.tezturist.fragmentsPrincipales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation.findNavController
import com.example.tezturist.R

class FragmentUno : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uno, container, false)
    }

    // Método creado por mí, este está usando el botón del FragmentUno (inicio) para pasar a una actividad
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnActivityAtoluca = view.findViewById<Button>(R.id.btnVerMasAtoluca)
        val btnRutaAtoluca = view.findViewById<Button>(R.id.btnVerMapaAtoluca)
        btnActivityAtoluca.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activityAtoluca) }
        btnRutaAtoluca.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }


        val btnAcivityTez = view.findViewById<Button>(R.id.btnVerMasTez)
        val btnRutaTez = view.findViewById<Button>(R.id.btnVerMapaTez)
        btnAcivityTez.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activityTeziutlan) }
        btnRutaTez.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }

        val btnAcivityMexcal = view.findViewById<Button>(R.id.btnVerMasMexcal)
        val btnRutaMexcal = view.findViewById<Button>(R.id.btnVerMapaMexcal)
        btnAcivityMexcal.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activityMexcal) }
        btnRutaMexcal.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }

        val btnAcivityDiego = view.findViewById<Button>(R.id.btnVerMasDiego)
        val btnRutaDiego = view.findViewById<Button>(R.id.btnVerMapaDiego)
        btnAcivityDiego.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activityMexcal) }
        btnRutaDiego.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }


        val btnAcivitySebas = view.findViewById<Button>(R.id.btnVerMasSebas)
        val btnRutaSebas = view.findViewById<Button>(R.id.btnVerMapaSebas)
        btnAcivitySebas.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activitySanSebas) }
        btnRutaSebas.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }

        val btnAcivityAcateno = view.findViewById<Button>(R.id.btnVerMasAcateno)
        val btnRutaAcateno = view.findViewById<Button>(R.id.btnVerMapaAcateno)
        btnAcivityAcateno.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_activityAcateno) }
        btnRutaAcateno.setOnClickListener { v -> findNavController(v).navigate(R.id.action_page_inicio_to_page_rutas) }


    }


}