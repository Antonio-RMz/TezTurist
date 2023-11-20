package com.example.tezturist;
//fragmento donde se ve la informacion de firebase
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentTres extends Fragment {
    private FirebaseAuth auth;
    private Button button;
    private TextView textViewEmail;

    private FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tres, container, false);

        auth = FirebaseAuth.getInstance();
        button = view.findViewById(R.id.cerrarSesion);
        textViewEmail = view.findViewById(R.id.textEmail);

        // Iniciará al usuario actual
        user = auth.getCurrentUser();
        if (user == null) {
            // Condición que manda al login si no hay usuario, se finaliza la actividad y se manda a ActivityLogin
            Intent intent = new Intent(requireContext(), ActivityLogin.class);
            startActivity(intent);
            requireActivity().finish();
        } else {
            // Configura el correo electrónico del usuario
            textViewEmail.setText(user.getEmail());
        }

        // Detector al hacer clic en el botón cerrar sesión
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí se cierra la sesión
                FirebaseAuth.getInstance().signOut();
                // Cerrar la actividad actual y abrir la de inicio de sesión
                // Condición que manda al login si no hay usuario, se finaliza la actividad y se manda a ActivityLogin
                Intent intent = new Intent(requireContext(), ActivityLogin.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        return view;
    }
}
