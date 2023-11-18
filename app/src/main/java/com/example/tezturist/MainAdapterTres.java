package com.example.tezturist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import de.hdodenhof.circleimageview.CircleImageView;
public class MainAdapterTres  extends FirebaseRecyclerAdapter<MainModelTres,MainAdapterTres.myViewHolder> {
    public MainAdapterTres(@NonNull FirebaseRecyclerOptions<MainModelTres> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModelTres model) {
        holder.descripcion.setText(model.getDescripcion());

        holder.nombre.setText(model.getNombre());
        Glide.with(holder.img.getContext())
                .load(model.getImagen())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .centerCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_tres, parent, false);
        return new myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nombre, descripcion;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img1);
            nombre = (TextView)itemView.findViewById(R.id.nametext);
            descripcion = (TextView)itemView.findViewById(R.id.coursetext);

        }
    }

}
