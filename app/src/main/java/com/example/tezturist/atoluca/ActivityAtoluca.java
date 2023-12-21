package com.example.tezturist.atoluca;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.tezturist.MainActivity1;
import com.example.tezturist.atoluca.fragmentsBotones.FragmentActividades;
import com.example.tezturist.atoluca.fragmentsBotones.FragmentEventos;
import com.example.tezturist.atoluca.carruselAtoluca.ImageAdapter;
import com.example.tezturist.atoluca.carruselAtoluca.ImageViewActivity;
import com.example.tezturist.R;
import com.example.tezturist.atoluca.fragmentsBotones.FragmentHistoria;
import com.example.tezturist.clima.ActivityLugares;
import com.example.tezturist.clima.MainWeather;
import com.example.tezturist.fragmentsPrincipales.FragmentTres;
import com.example.tezturist.fragmentsPrincipales.FragmentUno;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ActivityAtoluca extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atoluca);
        //boton para abrir el clima
        Button btnClimaAtoluca = findViewById(R.id.btnClimaAtoluca);

//accion boton coordenadas para el clima
        btnClimaAtoluca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.9631125, -97.2328597);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/401694714_308024552215573_1226869390937196813_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeGpOusvfqz2-ZO0h8V_pwkrxlsesJsAvK3GWx6wmwC8rRk8XHqGnbV15XZ9Sm8rGF_lj2a9YdGaGcaejk9a7p5E&_nc_ohc=zfe-QkNjNT4AX9xbz03&_nc_ht=scontent.fjal2-1.fna&oh=00_AfANkyPnbWhyrx28-p9gSMRlGPaO_rWhMZgwXQ37l-mpMg&oe=65733170");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/391544016_290730580611637_4459653882412175187_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeGk3FP5aUI9jCMKm3q2x70IR3pLZLVagsVHektktVqCxRbZSrfDH8dNJqYfJ1K2MAW3Dx8Z7S-sBI9sxI2INSEY&_nc_ohc=sczHQyyTCo0AX8-Ahil&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBMmm93TsEjDRXar29EW7a6A300zT3Rcpxl3HIZ6ZiVUg&oe=65726F04");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/400814394_308632252154803_3193462725008491576_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeE5k0_BwajtY_HB6OvbzhyO4cXeKRz5at_hxd4pHPlq37MAndB8VWF3tKgmf3gP2AOKbKcqzw_W10RczOZ2Jsxs&_nc_ohc=MYbdbt_bRvAAX8DD_4Q&_nc_ht=scontent.fjal2-1.fna&oh=00_AfDffYdI8NVhV1xh16Mmf7d0xbW3wkF9jD4z66mUbv5j2Q&oe=6572C8E7");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/385745846_283824581302237_6873849786767605257_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeEDtScpwQDszyus89jOJf6zKM8XrGn9fVYozxesaf19Vrcgqlqi18J3OJeLi3gREq6nEcpHmh2YeiljOTrcP841&_nc_ohc=2f126WKfCvsAX_6zhdx&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAS1Rxeec7SY_P7CoG7oP3rjWdYqA91sx9fawbEAlsZXQ&oe=65730475");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/383978666_283408834677145_474455412324270084_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeGGrIksudLs-d3raZR_2ua-NKg9IysxjOg0qD0jKzGM6DDMnJuz_HJb2E0Jg85m9IXbBCkslBYZzMLzYUYFf0VT&_nc_ohc=Fq5Fvx2QpggAX8HwgHH&_nc_ht=scontent.fjal2-1.fna&oh=00_AfB-9wNYkeLjS9ayJNC4i7s4ZghyC3CvriHipChcJi9_KA&oe=6573D632");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/277367035_5266621276764458_6456781645946946891_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeGTvjFse8w4AZij3gnylhZS4NlgOwKgicPg2WA7AqCJw1SwKtfB1t0NOqwwtiaQucNsC5OYk2tKUh4W5sXx890H&_nc_ohc=uQn4d7Ubr_gAX8j3VKk&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAHw5cqCv5TqfrpuWNMZLVY94hXaR_c0wJgH4F0XKMjRQ&oe=657292CA");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/277776813_5266622383431014_8832189779301266335_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeEoC5fq3BFmVsDD4xKE9r8fK2CY5R9cBJ4rYJjlH1wEnq5DZadpAUGzJJJ45LdSOXd6VDGvFu9y8fnwNky66B2_&_nc_ohc=kdXvpB7ULgoAX8H4NfZ&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBiXgf1Sgwz04ADAiopW6twygLs30ylVfTphgydDAwLlA&oe=6573069B");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/391553252_292374713780557_8862572715429905558_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=dd5e9f&_nc_eui2=AeE3agzICn0Dbftd1beofqDZybumhb4_LxvJu6aFvj8vG9MTcH3D7dUO0DbWB-oO3BDO5VmyLJYMV5Y3elRjEUPN&_nc_ohc=cnqJHnfW0egAX_LWZSi&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBC5Sx3GIF5zjGvPa8kvGSrx8TbA_LwW4CYnatm7Cp2tA&oe=657352A0");

        ImageAdapter adapter = new ImageAdapter(ActivityAtoluca.this, arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String path) {
                startActivity(new Intent(ActivityAtoluca.this, ImageViewActivity.class).putExtra("image", path), ActivityOptions.makeSceneTransitionAnimation(ActivityAtoluca.this, imageView, "image").toBundle());


            }
        });
        // Configuración de los botones y sus manejadores de clics
        Button buttonActividades = findViewById(R.id.btnActividades);
        Button buttonEventos = findViewById(R.id.btnEventos);
        Button buttonHistoria = findViewById(R.id.btnHistoria);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) { //acciones para los tres botones de la actividad atoluca
                Fragment fragment;

                if (view.getId() == R.id.btnActividades) {
                    fragment = new FragmentActividades();
                } else if (view.getId() == R.id.btnEventos) {
                    fragment = new FragmentEventos();
                } else if (view.getId() == R.id.btnHistoria) {
                    fragment = new FragmentHistoria();
                } else {
                    fragment = new FragmentActividades(); // Fragmento predeterminado
                }

                // Reemplazar el fragmento en el FrameLayout(Contenedor de fragmentos para cambiar con los botones)
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();
            }
        };

        buttonActividades.setOnClickListener(buttonClickListener);
        buttonEventos.setOnClickListener(buttonClickListener);
        buttonHistoria.setOnClickListener(buttonClickListener);


        ///1 para la barra lateral atoluca
        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

//metodo para mandar los parametos del clima de atoluca

    private void abrirMainWeather(double latitude, double longitude) {
        Intent intent = new Intent(ActivityAtoluca.this, MainWeather.class);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }

    //2 metodo para la barra lateral atoluca, darle acciones
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_inicio) {
            // Iniciar una nueva actividad con FragmentUno
            Intent intent = new Intent(ActivityAtoluca.this, MainActivity1.class);
            intent.putExtra("fragment", "FragmentUno");
            startActivity(intent);
        } else if (itemId == R.id.nav_configuracion) {
            // Iniciar una nueva actividad con FragmentTres
            Intent intent = new Intent(ActivityAtoluca.this, FragmentTres.class);
            intent.putExtra("fragment", "FragmentTres");
            startActivity(intent);
        }
        // Puedes agregar más bloques if para otros ítems según sea necesario...

        drawerLayout.closeDrawer(GravityCompat.START); // Cerrar la barra lateral después de hacer clic
        return true;
    }

}
