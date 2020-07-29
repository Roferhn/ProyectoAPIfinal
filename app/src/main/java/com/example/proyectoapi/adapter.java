package com.example.proyectoapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    private Context mContext;
    private List<Juegos> mDatos;
    RequestOptions option;

    public adapter() {
    }

    public adapter(Context mContext, List<Juegos> lst) {
        this.mContext = mContext;
        this.mDatos = lst;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.lista, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tvNombre.setText(mDatos.get(position).getNombre());
        holder.tvRating.setText(mDatos.get(position).getRating());

        Glide.with(mContext).load(mDatos.get(position).getImagen()).apply(option).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mDatos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre, tvRating;
        ImageView img;




        public ViewHolder(View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.Jtitulo);
            tvRating = itemView.findViewById(R.id.Jrating);
            img = itemView.findViewById(R.id.Jimagen);

        }
    }

}
