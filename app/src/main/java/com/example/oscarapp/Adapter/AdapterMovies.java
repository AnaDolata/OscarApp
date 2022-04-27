package com.example.oscarapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.Model.Movie;
import com.example.oscarapp.R;
import com.example.oscarapp.apiMovie.DownloadTask;

import java.util.List;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.MyViewHolder> {

    private List<Movie> listMovies;

    public AdapterMovies(List<Movie> list){
        this.listMovies = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome, genero;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            nome = view.findViewById(R.id.textViewName);
            genero = view.findViewById(R.id.textViewGender);
            img = view.findViewById(R.id.imageViewMovie);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_movies, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie obj = listMovies.get(position);
        holder.nome.setText(obj.getNome());
        holder.genero.setText(obj.getGenero());
        String url = obj.getFoto();
        DownloadTask task = new DownloadTask(holder.img);
        task.execute(url);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

}
