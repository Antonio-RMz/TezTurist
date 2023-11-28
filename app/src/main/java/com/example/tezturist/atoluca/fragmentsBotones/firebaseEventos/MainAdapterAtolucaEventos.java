package com.example.tezturist.atoluca.fragmentsBotones.firebaseEventos;

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

public class MainAdapterAtolucaEventos  extends FirebaseRecyclerAdapter<MainModelAtolucaEventos, MainAdapterAtolucaEventos.myViewHolder> {

    public MainAdapterAtolucaEventos(@NonNull FirebaseRecyclerOptions<MainModelAtolucaEventos> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModelAtolucaEventos model) {
        holder.descripcionE.setText(model.getDescripcionE());

        holder.nombreE.setText(model.getNombreE());
        Glide.with(holder.imgE.getContext())
                .load(model.getImagenE())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .centerCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.imgE);
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_atoluca_eventos, parent, false);
        return new MainAdapterAtolucaEventos.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imgE;
        TextView nombreE, descripcionE;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imgE= (ImageView) itemView.findViewById(R.id.img_atoluca_evento);
            nombreE = (TextView)itemView.findViewById(R.id.txt_nombre_eventos_atoluca);
            descripcionE = (TextView)itemView.findViewById(R.id.txt_descripcion_eventos_atoluca);

        }
    }
}
