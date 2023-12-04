package com.example.tezturist.acateno.carruselAcateno;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tezturist.R;



import java.util.ArrayList;

public class ImageAdapterAcateno extends RecyclerView.Adapter<ImageAdapterAcateno.ViewHolder> {

    Context context;
    ArrayList<String> arrayList;
    ImageAdapterAcateno.OnItemClickListener onItemClickListener;
    public ImageAdapterAcateno(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public ImageAdapterAcateno.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_list_item_acateno, parent, false);
        return new ImageAdapterAcateno.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterAcateno.ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position)).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(holder.imageView, arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_item_image);
        }
    }

    public void setOnItemClickListener(ImageAdapterAcateno.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(ImageView imageView, String path);
    }
}
