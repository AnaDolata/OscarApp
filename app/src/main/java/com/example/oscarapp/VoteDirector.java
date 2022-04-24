package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.oscarapp.Model.Director;
import com.example.oscarapp.apiMovie.RetrofitConfig;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteDirector extends AppCompatActivity {


    List<Director> directorList;
    RadioGroup rg = findViewById(R.id.rgDiretor);
    RadioButton[] rb = new RadioButton[directorList.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_director);
    }

    public void getData (View view){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando Diretores ...");
        progressDialog.show();

        Call<List<Director>> call = new RetrofitConfig().getDirectorService().getDirector();
        call.enqueue(new Callback<List<Director>>() {
            @Override
            public void onResponse(Call<List<Director>> call, Response<List<Director>> response) {
                if(response.isSuccessful()){
                    directorList = response.body();

                    for(int i = 0; i < directorList.size(); i++){
                        Director director = directorList.get(i);
                        rb[i].setText("\n"+director.getNome());
                        rb[i].setId(i+1);
                        rg.addView(rb[i]);
                    }
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Director>> call, Throwable t) {
            }
        });
    }
}