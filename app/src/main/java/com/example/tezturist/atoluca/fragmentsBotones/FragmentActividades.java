package com.example.tezturist.atoluca.fragmentsBotones;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tezturist.atoluca.fragmentsBotones.firebaseActividades.MainAdapterAtolucaActividades;
import com.example.tezturist.atoluca.fragmentsBotones.firebaseActividades.MainModelAtolucaActividades;
import com.example.tezturist.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentActividades extends Fragment {

    RecyclerView recyclerViewActividades;
    MainAdapterAtolucaActividades mainAdapterActividades;

    public FragmentActividades() {
        // Required empty public constructor
    }

    public static FragmentActividades newInstance(String param1, String param2) {
        FragmentActividades fragment = new FragmentActividades();
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
        View view = inflater.inflate(R.layout.fragment_actividades, container, false);

        recyclerViewActividades = view.findViewById(R.id.recyclerViewActividades);
        recyclerViewActividades.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<MainModelAtolucaActividades> options =
                new FirebaseRecyclerOptions.Builder<MainModelAtolucaActividades>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("actividades"), MainModelAtolucaActividades.class)
                        .build();
        mainAdapterActividades = new MainAdapterAtolucaActividades(options);
        recyclerViewActividades.setAdapter(mainAdapterActividades);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapterActividades.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapterActividades.stopListening();
    }
}
