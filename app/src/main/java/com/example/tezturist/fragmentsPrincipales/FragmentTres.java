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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class FragmentTres extends Fragment {

    private TextView emailTextView;
    private MaterialButton logoutButton;
    EditText firstNameEditText, lastNameEditText, middleNameEditText;
    MaterialButton guardarButton, actualizarButton, cambiarImgButton;


    ///para imagen firebase storage
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private DatabaseReference userReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;




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
//boton cierre de sesion con firebase y google
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Cerrar sesión con Firebase (correo)
                    FirebaseAuth.getInstance().signOut();

                    // Cerrar sesión con Google
                    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .build();
                    GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
                    googleSignInClient.signOut().addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // Después de cerrar sesión con Firebase y Google, redirige a la pantalla de inicio de sesión
                            Intent intent = new Intent(getActivity(), LoginActivity1.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                    });
                }
            });
            //accion para cambiar imagen
            cambiarImgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
            });
        }

        // Inicializar Firebase Storage
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        return view;
    }

    private void saveUserInfo() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String middleName = middleNameEditText.getText().toString();

        User user = new User(firstName, lastName, middleName);
        userReference.setValue(user);
    }


    //cuando se carga la informacion del usuario
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

                        String imageUrl = user.getImageUrl();
                        if (imageUrl != null && !imageUrl.isEmpty()) {
                            //  cargar la imagen desde la URL en CircleImageView
                            Picasso.get().load(imageUrl).into(imageView);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // se manejan errores de lectura
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                imageView.setImageBitmap(bitmap);

                // Subir la imagen a Firebase Storage
                uploadImageToFirebaseStorage(selectedImageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    //imagen para usuario
    private void uploadImageToFirebaseStorage(Uri uri) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Crear una referencia única para la imagen
            String imageName = "profile_images/" + user.getUid() + ".jpg";
            StorageReference imageRef = storageReference.child(imageName);

            // Subir la imagen al Storage
            imageRef.putFile(uri)
                    .addOnSuccessListener(taskSnapshot -> {
                        // Obtiene la URL de la imagen después de subirla con éxito
                        imageRef.getDownloadUrl().addOnSuccessListener(uri1 -> {
                            // Aquí puedes guardar la URL en la base de datos de Firebase Realtime Database o Firestore
                            String imageUrl = uri1.toString();
                            userReference.child("imageUrl").setValue(imageUrl);
                        });
                    })
                    .addOnFailureListener(e -> {
                        // Maneja errores de carga de imagen
                        showToast("Error al subir la imagen");
                    });
        }
    }
}
