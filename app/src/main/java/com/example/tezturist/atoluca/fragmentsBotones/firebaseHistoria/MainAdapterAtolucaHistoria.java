package com.example.tezturist.atoluca.fragmentsBotones.firebaseHistoria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tezturist.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainAdapterAtolucaHistoria extends FirebaseRecyclerAdapter<MainModelAtolucaHistoria, MainAdapterAtolucaHistoria.myViewHolder> {

    public MainAdapterAtolucaHistoria(@NonNull FirebaseRecyclerOptions<MainModelAtolucaHistoria> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainAdapterAtolucaHistoria.myViewHolder holder, int position, @NonNull MainModelAtolucaHistoria model) {
        holder.descripcionH.setText(model.getDescripcionH());
        holder.nombreH.setText(model.getNombreH());

        Glide.with(holder.imgH.getContext())
                .load(model.getImagenH())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .centerCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.imgH);
    }

    @NonNull
    @Override
    public MainAdapterAtolucaHistoria.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_atoluca_historia, parent, false);
        return new MainAdapterAtolucaHistoria.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imgH;
        TextView nombreH, descripcionH;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imgH = itemView.findViewById(R.id.img_atoluca_historia);
            nombreH = itemView.findViewById(R.id.txt_nombre_historia_atoluca);
            descripcionH = itemView.findViewById(R.id.txt_descripcion_historia_atoluca);
        }
    }
}
