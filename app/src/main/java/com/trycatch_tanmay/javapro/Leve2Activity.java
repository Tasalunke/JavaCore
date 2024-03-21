package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Leve2Activity extends AppCompatActivity {
    ViewPager level2ViewPager;
    Level2_A_Adapter level2AAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leve2);
        level2ViewPager = findViewById(R.id.Level2_RV);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
        getLevel2Data(3);
    }

    private void getLevel2Data(int category_id) {
        Call<PojoLevel2_B> call = ApiClient.getJavapro().getLevel2Data(category_id);
        call.enqueue(new Callback<PojoLevel2_B>() {
            @Override
            public void onResponse(Call<PojoLevel2_B> call, Response<PojoLevel2_B> response) {
                if (response.code() == 200 && response.body() != null) {
                    PojoLevel2_B pojoLevel2B = response.body();
                    setViewPager(pojoLevel2B); // Corrected the variable name here
                } else {
                    Toast.makeText(Leve2Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PojoLevel2_B> call, Throwable t) {
                Toast.makeText(Leve2Activity.this, "Network failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setViewPager(PojoLevel2_B pojoLevel2B) {
        level2AAdapter = new Level2_A_Adapter(Leve2Activity.this, pojoLevel2B);
        level2ViewPager.setAdapter(level2AAdapter);
    }
}
