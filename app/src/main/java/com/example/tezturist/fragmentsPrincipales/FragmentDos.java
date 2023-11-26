package com.example.tezturist.fragmentsPrincipales;
//fragmento para la clase google maps
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tezturist.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentDos extends Fragment implements OnMapReadyCallback {

    private GoogleMap myMap;

    public FragmentDos() {
        // Required empty public constructor
    }

    public static FragmentDos newInstance(String param1, String param2) {
        FragmentDos fragment = new FragmentDos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
//metodo que muestra la vista del mapa en el fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dos, container, false);

        // Obtén el fragmento de mapa de soporte
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        // Registra el callback para ser notificado cuando el mapa esté listo para ser usado
        mapFragment.getMapAsync(this);

        return view;
    }
//metodo que contiene la informacion de todos los marcadores a mostrar
    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        // Agrega un marcador en Sydney y mueve la cámara
       /* LatLng sydney = new LatLng(-34, 151);
        myMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        */


        // Centrar la cámara en Teziutlán
        LatLng teziutlanLatLng = new LatLng(19.8172796,-97.40218);
        myMap.moveCamera(CameraUpdateFactory.newLatLng(teziutlanLatLng));
        float zoomLevel = 14.0f; // Puedes ajustar este valor según tus preferencias
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teziutlanLatLng, zoomLevel));



        mapSanDiego(googleMap);
        mapMexcal(googleMap);
        mapAcateno(googleMap);
        mapAtoluca(googleMap);
        mapSanSebas(googleMap);
    }
//marcadores individuales
    public void mapAtoluca(GoogleMap googleMap) {
        myMap = googleMap;

        // Cargar la imagen del recurso drawable
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_maps_atoluca);

        // Cargar la imagen nuevamente para obtener las dimensiones originales
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_atoluca, options);

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        // Definir un factor de escala para ajustar el tamaño de la imagen
        float scaleFactor = 0.25f; // Puedes ajustar este valor según tus necesidades

        // Calcular las nuevas dimensiones de la imagen después de escalarla
        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Escalar la imagen al nuevo tamaño
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_atoluca), scaledWidth, scaledHeight, false);

        // Crear un nuevo BitmapDescriptor con la imagen escalada
        BitmapDescriptor scaledIcon = BitmapDescriptorFactory.fromBitmap(scaledBitmap);

        // Añadir un marcador en Atoluca con la imagen escalada
        final LatLng puntoAtoluca = new LatLng(19.8589316,-97.3477937);
        myMap.addMarker(new MarkerOptions().position(puntoAtoluca).title("Atoluca").icon(scaledIcon));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(puntoAtoluca));
    }


    public void mapMexcal(GoogleMap googleMap) {
        myMap = googleMap;

        // Cargar la imagen del recurso drawable
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_maps_mexcal);

        // Cargar la imagen nuevamente para obtener las dimensiones originales
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_mexcal, options);

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        // Definir un factor de escala para ajustar el tamaño de la imagen
        float scaleFactor = 0.25f; // Puedes ajustar este valor según tus necesidades

        // Calcular las nuevas dimensiones de la imagen después de escalarla
        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Escalar la imagen al nuevo tamaño
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_mexcal), scaledWidth, scaledHeight, false);

        // Crear un nuevo BitmapDescriptor con la imagen escalada
        BitmapDescriptor scaledIcon = BitmapDescriptorFactory.fromBitmap(scaledBitmap);

        // Añadir un marcador en Atoluca con la imagen escalada
        final LatLng puntoMexcal = new LatLng(19.867216,-97.3914972);
        myMap.addMarker(new MarkerOptions().position(puntoMexcal).title("Mexcal").icon(scaledIcon));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(puntoMexcal));
    }




    public void mapSanSebas(GoogleMap googleMap) {
        myMap = googleMap;

        // Cargar la imagen del recurso drawable
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_maps_sansebas);

        // Cargar la imagen nuevamente para obtener las dimensiones originales
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_sansebas, options);

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        // Definir un factor de escala para ajustar el tamaño de la imagen
        float scaleFactor = 0.25f; // Puedes ajustar este valor según tus necesidades

        // Calcular las nuevas dimensiones de la imagen después de escalarla
        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Escalar la imagen al nuevo tamaño
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_sansebas), scaledWidth, scaledHeight, false);

        // Crear un nuevo BitmapDescriptor con la imagen escalada
        BitmapDescriptor scaledIcon = BitmapDescriptorFactory.fromBitmap(scaledBitmap);

        // Añadir un marcador en Atoluca con la imagen escalada
        final LatLng puntoSanSebas = new LatLng(19.8553406,-97.3708474);
        myMap.addMarker(new MarkerOptions().position(puntoSanSebas).title("San sebastian").icon(scaledIcon));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(puntoSanSebas));
    }

    public void mapAcateno(GoogleMap googleMap) {
        myMap = googleMap;

        // Cargar la imagen del recurso drawable
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_maps_acateno);

        // Cargar la imagen nuevamente para obtener las dimensiones originales
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_acateno, options);

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        // Definir un factor de escala para ajustar el tamaño de la imagen
        float scaleFactor = 0.25f; // Puedes ajustar este valor según tus necesidades

        // Calcular las nuevas dimensiones de la imagen después de escalarla
        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Escalar la imagen al nuevo tamaño
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_acateno), scaledWidth, scaledHeight, false);

        // Crear un nuevo BitmapDescriptor con la imagen escalada
        BitmapDescriptor scaledIcon = BitmapDescriptorFactory.fromBitmap(scaledBitmap);

        // Añadir un marcador en Atoluca con la imagen escalada
        final LatLng puntoAcateno = new LatLng(19.8753223,-97.3673095);
        myMap.addMarker(new MarkerOptions().position(puntoAcateno).title("Acateno").icon(scaledIcon));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(puntoAcateno));
    }
    public void mapSanDiego(GoogleMap googleMap) {
        myMap = googleMap;

        // Cargar la imagen del recurso drawable
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_maps_sandiego);

        // Cargar la imagen nuevamente para obtener las dimensiones originales
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_sandiego, options);

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        // Definir un factor de escala para ajustar el tamaño de la imagen
        float scaleFactor = 0.25f; // Puedes ajustar este valor según tus necesidades

        // Calcular las nuevas dimensiones de la imagen después de escalarla
        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Escalar la imagen al nuevo tamaño
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_maps_sandiego), scaledWidth, scaledHeight, false);

        // Crear un nuevo BitmapDescriptor con la imagen escalada
        BitmapDescriptor scaledIcon = BitmapDescriptorFactory.fromBitmap(scaledBitmap);

        // Añadir un marcador en Atoluca con la imagen escalada
        final LatLng puntoSanDiego = new LatLng(19.8562956,-97.3609784);
        myMap.addMarker(new MarkerOptions().position(puntoSanDiego).title("San Diego").icon(scaledIcon));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(puntoSanDiego));
    }




}
