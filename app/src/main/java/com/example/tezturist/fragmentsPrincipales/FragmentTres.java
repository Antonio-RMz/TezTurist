package com.example.tezturist.fragmentsPrincipales;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.tezturist.R;
import com.example.tezturist.login1.LoginActivity1;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class FragmentTres extends Fragment {

    private TextView emailTextView;
    private MaterialButton logoutButton;
    EditText firstNameEditText, lastNameEditText, middleNameEditText;
    MaterialButton guardarButton, actualizarButton, cambiarImgButton;
    DatabaseReference userReference;
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tres, container, false);

        emailTextView = view.findViewById(R.id.emailTextView);
        logoutButton = view.findViewById(R.id.logoutButton);
        firstNameEditText = view.findViewById(R.id.firstNameEditText);
        lastNameEditText = view.findViewById(R.id.lastNameEditText);
        middleNameEditText = view.findViewById(R.id.middleNameEditText);
        guardarButton = view.findViewById(R.id.buttonGuardar);
        actualizarButton = view.findViewById(R.id.buttonActualizar);
        cambiarImgButton = view.findViewById(R.id.cambiarImgButton);
        imageView = view.findViewById(R.id.imageView);


        Switch switchTheme = view.findViewById(R.id.switch_theme);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            emailTextView.setText(user.getEmail());
            userReference = FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());
            loadUserInfo();

            guardarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveUserInfo();
                    showToast("Información guardada exitosamente");
                }
            });

            //para cambiar el modo claro o obscuro
            switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton button, boolean isChecked) {

                    if(isChecked) {
                        // Habilitar tema oscuro
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    } else {
                        // Deshabilitar tema oscuro
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                }
            });

            actualizarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firstNameEditText.setText("");
                    lastNameEditText.setText("");
                    middleNameEditText.setText("");
                    showToast("Campos vacíos");
                }
            });

            cambiarImgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
            });

            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getActivity(), LoginActivity1.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }

        return view;
    }

    private void saveUserInfo() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String middleName = middleNameEditText.getText().toString();

        User user = new User(firstName, lastName, middleName);
        userReference.setValue(user);
    }

    private void loadUserInfo() {
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    User user = snapshot.getValue(User.class);
                    if (user != null) {
                        firstNameEditText.setText(user.getFirstName());
                        lastNameEditText.setText(user.getLastName());
                        middleNameEditText.setText(user.getMiddleName());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de lectura
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            showToast("Imagen nueva");

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
