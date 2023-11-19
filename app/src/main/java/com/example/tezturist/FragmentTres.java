package com.example.tezturist;
//fragmento donde se ve la informacion de firebase
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentTres extends Fragment {

    RecyclerView recyclerView;
    MainAdapterTres mainAdapter;

    public FragmentTres() {
        // Required empty public constructor
    }

//segun yo este fragment tres no sirve pa nada
    public static FragmentTres newInstance(String param1, String param2) {
        FragmentTres fragment = new FragmentTres();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tres, container, false);

        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<MainModelTres> options =
                new FirebaseRecyclerOptions.Builder<MainModelTres>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("sitios"), MainModelTres.class)
                        .build();
        mainAdapter = new MainAdapterTres(options);
        recyclerView.setAdapter(mainAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}
