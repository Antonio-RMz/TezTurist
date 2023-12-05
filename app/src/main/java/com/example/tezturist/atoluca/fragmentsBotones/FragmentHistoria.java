package com.example.tezturist.atoluca.fragmentsBotones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tezturist.R;
import com.example.tezturist.atoluca.fragmentsBotones.firebaseHistoria.MainAdapterAtolucaHistoria;
import com.example.tezturist.atoluca.fragmentsBotones.firebaseHistoria.MainModelAtolucaHistoria;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentHistoria extends Fragment {

    RecyclerView recyclerViewHistoria;
    MainAdapterAtolucaHistoria mainAdapterHistoria;

    public FragmentHistoria() {
        // Required empty public constructor
    }

    public static FragmentHistoria newInstance(String param1, String param2) {
        FragmentHistoria fragment = new FragmentHistoria();
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
        View view = inflater.inflate(R.layout.fragment_historia, container, false);

        recyclerViewHistoria = view.findViewById(R.id.recyclerViewHistoria);
        recyclerViewHistoria.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<MainModelAtolucaHistoria> options =
                new FirebaseRecyclerOptions.Builder<MainModelAtolucaHistoria>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("historiaActividades"), MainModelAtolucaHistoria.class)
                        .build();

        mainAdapterHistoria = new MainAdapterAtolucaHistoria(options);
        recyclerViewHistoria.setAdapter(mainAdapterHistoria);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapterHistoria.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapterHistoria.stopListening();
    }
}
