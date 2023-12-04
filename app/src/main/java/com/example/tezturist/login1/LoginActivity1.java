package com.example.tezturist.login1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tezturist.MainActivity;
import com.example.tezturist.MainActivity1;
import com.example.tezturist.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.regex.Pattern;

public class LoginActivity1 extends AppCompatActivity {
    TextView bienvenidoLabel, continuarLabel, nuevoUsuario, olvidasteContrasena;
    ImageView loginImageView;
    TextInputLayout usuarioTextFile, contraseñaTextFile;
    MaterialButton inicioSesion;
    //elementos para logica de iniciar sesion
    TextInputEditText emailEditText, passwordEditText;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

//para logeo con google

    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;
    public static final int RC_SIGN_IN = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);


        loginImageView = findViewById(R.id.loginImageView);
        bienvenidoLabel = findViewById(R.id.bienvenidoLabel);
        continuarLabel = findViewById(R.id.continuarLabel);
        usuarioTextFile = findViewById(R.id.usuarioTextFile);
        contraseñaTextFile = findViewById(R.id.contraseñaTextFile);
        inicioSesion = findViewById(R.id.inicioSesion);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
      //  olvidasteContrasena = findViewById(R.id.olvidasteContra);

        progressBar = findViewById(R.id.circuloProgreso);

        //referencias para boton iniciar sesion

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById((R.id.passwordEditText));
        mAuth = FirebaseAuth.getInstance();


        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //de donde estamos a donde queremos ir
                Intent intent = new Intent(LoginActivity1.this, SignUpActivity1.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(loginImageView, "loginImageTrans");
                pairs[1] = new Pair<View, String>(bienvenidoLabel, "textTrans");
                pairs[2] = new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
                pairs[3] = new Pair<View, String>(usuarioTextFile, "emailInputTextTrans");
                pairs[4] = new Pair<View, String>(contraseñaTextFile, "passwordInputTextTrans");
                pairs[5] = new Pair<View, String>(inicioSesion, "buttonSingInTrans");
                pairs[6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");

                //si la version del jdk no soporta que se salte la animacion
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity1.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });


        olvidasteContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity1.this, ForgotPassword1.class);
                startActivity(intent);
                finish();
            }
        });


        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();//validar si es un correo valido y validar contrase;a
            }
        });


      /*  signInButton = findViewById(R.id.loginGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });*/


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    //metodo para autenticacion con google
    private void signInWithGoogle() {
//llamar al dialogo que sale cuando precionamos btn google
        Intent singnInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(singnInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Toast.makeText(LoginActivity1.this, "Fallo inicio con Google", Toast.LENGTH_SHORT).show();

            }
        }

    }


    //cuando se cierre el dialogo se debe almacenar un token, aqui
    public void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity1.this, MainActivity1.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity1.this, "Fallo en iniciar sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void validate() {
        progressBar.setVisibility(View.VISIBLE);
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        //si el email es vacio o si es o no una direccion de email
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Correo invalido ");
            return;
        } else {
            emailEditText.setError(null);
        }

        //metodo que va a mandar los datos a firebase para que se registren
        inicioSesion(email, password);

    }

    public void inicioSesion(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //se comnparan las credenciales y si pasa, ya puede iniciar sesion con el usuario
                            Intent intent = new Intent(LoginActivity1.this, MainActivity1.class);
                            startActivity(intent);
                            finish();
                        } else {//si la contrasenia no es
                            Toast.makeText(LoginActivity1.this, "Credenciales equivocadas, trata de nuevo", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    private void signOut() {
        FirebaseAuth.getInstance().signOut();

        // Revocar el acceso a la cuenta de Google
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                // Limpiar las credenciales almacenadas
                mGoogleSignInClient.revokeAccess().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Acciones adicionales después de cerrar sesión y revocar el acceso
                        // Por ejemplo, redirigir a la pantalla de inicio de sesión
                        redirectToLoginScreen();
                    }
                });
            }
        });
    }

    private void redirectToLoginScreen() {
        // Puedes redirigir a la pantalla de inicio de sesión aquí
        Intent intent = new Intent(LoginActivity1.this, LoginActivity1.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual para evitar volver atrás
    }


}
