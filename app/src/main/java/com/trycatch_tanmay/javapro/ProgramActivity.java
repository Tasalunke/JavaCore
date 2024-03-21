package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgramActivity extends AppCompatActivity {
RecyclerView prgm_recyclerview;
ProgramAdapter programAdapter;
    GifImageView gif2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        prgm_recyclerview=findViewById(R.id.prgm_recyclerview);
        getPrgmData();
        gif2 = findViewById(R.id.gif_panda2);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));

    }
    private void getPrgmData(){
        Call<ArrayList<Pojo_Program>>call=ApiClient.getJavapro().getProgramData();
        call.enqueue(new Callback<ArrayList<Pojo_Program>>() {
            @Override
            public void onResponse(Call<ArrayList<Pojo_Program>> call, Response<ArrayList<Pojo_Program>> response) {
                if (response.code()==200 && response.body()!=null){
                    gif2.setVisibility(View.GONE);
                    prgm_recyclerview.setVisibility(View.VISIBLE);
                    ProgramAdapter programadapter =new ProgramAdapter(ProgramActivity.this,response.body());
                    prgm_recyclerview.setLayoutManager(new LinearLayoutManager(ProgramActivity.this));
                    prgm_recyclerview.setAdapter(programadapter);
                } else if (response.code()==401) {
                    Toast.makeText(ProgramActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ProgramActivity.this, "Authorized ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pojo_Program>> call, Throwable t) {
                Toast.makeText(ProgramActivity.this, "something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}