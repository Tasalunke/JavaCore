package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Level3Activity extends AppCompatActivity {
ViewPager Level3_RV;
Level3_B_Adapter level3_b_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        Level3_RV= findViewById(R.id.Level3_RV);
        getLevel3(4);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
    }

    private void getLevel3(int category){
        Call<PojoLevel3_A>call = ApiClient.getJavapro().getlevel3data(category);
        call.enqueue(new Callback<PojoLevel3_A>() {
            @Override
            public void onResponse(Call<PojoLevel3_A> call, Response<PojoLevel3_A> response) {
                if (response.code()==200 && response.body() != null){
                    Level3_B_Adapter level3_b_adapter= new Level3_B_Adapter(Level3Activity.this, response.body());
                    Level3_RV.setAdapter(level3_b_adapter);
                }else {
                    Toast.makeText(Level3Activity.this, "SomeThing went wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PojoLevel3_A> call, Throwable t) {
                Toast.makeText(Level3Activity.this, "Network Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setviewpager(PojoLevel3_A pojoLevel3A){
        level3_b_adapter = new Level3_B_Adapter(Level3Activity.this,pojoLevel3A);
        Level3_RV.setAdapter(level3_b_adapter);

    }
}