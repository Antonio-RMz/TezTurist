package com.example.tezturist.fragmentsPrincipales;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tezturist.R;
import com.example.tezturist.login1.LoginActivity1;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentTres extends Fragment {
    private TextView emailTextView;
    private MaterialButton logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_tres, container, false);

        // Busca las referencias de TextView y MaterialButton
        emailTextView = view.findViewById(R.id.emailTextView);
        logoutButton = view.findViewById(R.id.logoutButton);

        // Obtiene el usuario actualmente autenticado mediante Firebase Authentication
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Coloca el correo en el TextView
            emailTextView.setText(user.getEmail());
        }

        // Configura un OnClickListener para el botón de cierre de sesión
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la sesión cuando se presiona el botón
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity1.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
