package com.example.oscarapp.Adapter;


import com.example.oscarapp.Model.Director;
import com.example.oscarapp.R;
import com.google.android.material.radiobutton.MaterialRadioButton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class AdapterDirector extends RecyclerView.Adapter<AdapterDirector.MyViewHolder>{

        private List<Director> directorList;

        public AdapterDirector(List<Director> list){
            this.directorList = list;
        }


        @NonNull
        @Override
        public AdapterDirector.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View listItem = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_list_director, parent, false);

            return new MyViewHolder(listItem);

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Director director = directorList.get(position);
            holder.radio.setId(director.getId());
            holder.nome.setText(director.getNome());
        }

        @Override
        public int getItemCount() {
            return directorList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

            RadioGroup radio;
            TextView nome;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                radio = itemView.findViewById(R.id.radioDirector);
                nome = itemView.findViewById(R.id.txtDiretor);
            }
        }
    }
