package com.trycatch_tanmay.javapro;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Level1Activity extends AppCompatActivity {
    ViewPager level1ViewPager;
    Level1_B_Adapter level1BAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        level1ViewPager = findViewById(R.id.Level1_RV);
        getLevel1(2);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
    }

    private void getLevel1(int category_id) {
        Call<PojoLevel1_B> call = ApiClient.getJavapro().getlevel1data(category_id);
        call.enqueue(new Callback<PojoLevel1_B>() {
            @Override
            public void onResponse(Call<PojoLevel1_B> call, Response<PojoLevel1_B> response) {
                if (response.code() == 200 && response.body() != null) {
                   Level1_B_Adapter level1BAdapter= new Level1_B_Adapter(Level1Activity.this,response.body());
                    level1ViewPager.setAdapter(level1BAdapter);
                } else {
                    // Handle the case where the response is not successful
                    Toast.makeText(Level1Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PojoLevel1_B> call, Throwable t) {
                // Handle the network failure
                Toast.makeText(Level1Activity.this, "Network failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setViewPager(PojoLevel1_B pojoLevel1B) {
        level1BAdapter = new Level1_B_Adapter(Level1Activity.this, pojoLevel1B);
        level1ViewPager.setAdapter(level1BAdapter);
    }
}
