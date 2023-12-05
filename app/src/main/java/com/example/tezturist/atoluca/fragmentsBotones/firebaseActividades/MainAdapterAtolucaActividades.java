package com.example.tezturist.atoluca.fragmentsBotones.firebaseActividades;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CheckBox; // Agrega la importación del CheckBox

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tezturist.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainAdapterAtolucaActividades extends FirebaseRecyclerAdapter<MainModelAtolucaActividades, MainAdapterAtolucaActividades.myViewHolder> {
    public MainAdapterAtolucaActividades(@NonNull FirebaseRecyclerOptions<MainModelAtolucaActividades> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModelAtolucaActividades model) {
        holder.descripcion.setText(model.getDescripcion());
        holder.nombre.setText(model.getNombre());
        Glide.with(holder.img.getContext())
                .load(model.getImagen())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .centerCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        // Configuración del CheckBox y contador de reacciones
        holder.checkBox.setChecked(false); // Puedes establecerlo inicialmente según el estado del modelo


        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_atoluca_actividades, parent, false);
        return new MainAdapterAtolucaActividades.myViewHolder(view);
    }

    public void setAdapter(MainAdapterAtolucaActividades mainAdapterHistoria) {
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nombre, descripcion;
        CheckBox checkBox; // Agrega el CheckBox
        TextView contadorReacciones; // Agrega el TextView para el contador

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_atoluca_actividad);
            nombre = itemView.findViewById(R.id.txt_nombre_actividad_atuluca);
            descripcion = itemView.findViewById(R.id.txt_descripcion_actividad_attoluca);
            checkBox = itemView.findViewById(R.id.checkBox); // Inicializa el CheckBox

        }
    }
}
