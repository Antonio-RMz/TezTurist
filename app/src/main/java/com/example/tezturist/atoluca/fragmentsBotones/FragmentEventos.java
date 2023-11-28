package com.example.tezturist.atoluca.fragmentsBotones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tezturist.R;

import com.example.tezturist.atoluca.fragmentsBotones.firebaseEventos.MainAdapterAtolucaEventos;
import com.example.tezturist.atoluca.fragmentsBotones.firebaseEventos.MainModelAtolucaEventos;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEventos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEventos extends Fragment {

    RecyclerView recyclerViewEventos;
    MainAdapterAtolucaEventos mainAdapterEventos;
    public FragmentEventos() {
        // Required empty public constructor
    }


    public static FragmentEventos newInstance(String param1, String param2) {
        FragmentEventos fragment = new FragmentEventos();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);

        recyclerViewEventos = view.findViewById(R.id.recyclerViewEventos);
        recyclerViewEventos.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<MainModelAtolucaEventos> options =
                new FirebaseRecyclerOptions.Builder<MainModelAtolucaEventos>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("eventosAtoluca"), MainModelAtolucaEventos.class)
                        .build();
        mainAdapterEventos = new MainAdapterAtolucaEventos(options);
        recyclerViewEventos.setAdapter(mainAdapterEventos);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapterEventos.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapterEventos.stopListening();
    }

}