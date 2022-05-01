package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.oscarapp.Adapter.AdapterDirector;
import com.example.oscarapp.Model.Director;
import com.example.oscarapp.apiMovie.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteDirector extends AppCompatActivity {


    private List<Director> directorList = new ArrayList<>();
    private RecyclerView recyclerViewDiretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_director);

        recyclerViewDiretor = findViewById(R.id.recyclerViewDirector);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando diretores ...");
        progressDialog.show();

        Call <List<Director>> call = new RetrofitConfig().getDirectorService().getDirector();
        call.enqueue(new Callback<List<Director>>() {
            @Override
            public void onResponse(Call<List<Director>> call, Response<List<Director>> response) {

                if(response.isSuccessful()){
                    directorList = response.body();
                    AdapterDirector adapterDirector = new AdapterDirector(directorList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerViewDiretor.setLayoutManager(layoutManager);
                    recyclerViewDiretor.setHasFixedSize(true);
                    recyclerViewDiretor.setAdapter(adapterDirector);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Director>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(VoteDirector.this, "Erro ao buscar diretores", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnVotarDiretor (View view){

    }
}