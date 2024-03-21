package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intermediate1Activity extends AppCompatActivity {
    ViewPager viewPager;
    Intermediate_A_Adapter intermediateAAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate1);
        viewPager = findViewById(R.id.Interlvl_1_RV);
        getInterData1(5);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
    }

    private void getInterData1(int category) {
        Call<PojoIntermediate_1_A> call = ApiClient.getJavapro().getinterlvl1Data(category);
        call.enqueue(new Callback<PojoIntermediate_1_A>() {
            @Override
            public void onResponse(Call<PojoIntermediate_1_A> call, Response<PojoIntermediate_1_A> response) {
                if (response.code() == 200 && response.body() != null) {
                    PojoIntermediate_1_A pojoIntermediate1A = response.body();
                    setViewPager(pojoIntermediate1A);
                } else {
                    Toast.makeText(Intermediate1Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PojoIntermediate_1_A> call, Throwable t) {
                Toast.makeText(Intermediate1Activity.this, "Network failure", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setViewPager(PojoIntermediate_1_A pojoIntermediate1A) {
        intermediateAAdapter = new Intermediate_A_Adapter(Intermediate1Activity.this, pojoIntermediate1A);
        viewPager.setAdapter(intermediateAAdapter);
    }
}
