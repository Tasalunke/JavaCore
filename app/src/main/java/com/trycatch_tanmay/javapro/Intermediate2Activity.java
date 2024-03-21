package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intermediate2Activity extends AppCompatActivity {
    ViewPager Intr_lvl_2_RV;
    Intermediate_lvl_2_A_Adapter intermediateLvl2AAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate2);
        Intr_lvl_2_RV = findViewById(R.id.Intr_lvl_2_RV);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
getInterlvl2Data(6);
    }
private void getInterlvl2Data(int category_id){
    Call<PojoIntermediate_level_2_A>call=ApiClient.getJavapro().getinterlvl2Data(category_id);
    call.enqueue(new Callback<PojoIntermediate_level_2_A>() {
        @Override
        public void onResponse(Call<PojoIntermediate_level_2_A> call, Response<PojoIntermediate_level_2_A> response) {
            if (response.code()==200 &&response.body()!=null){
                PojoIntermediate_level_2_A pojoIntermediateLevel2A = response.body();
                setViewPager(pojoIntermediateLevel2A);
            }else {
                Toast.makeText(Intermediate2Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<PojoIntermediate_level_2_A> call, Throwable t) {
            Toast.makeText(Intermediate2Activity.this, "Network failure", Toast.LENGTH_SHORT).show();
        }
    });
}
private void setViewPager(PojoIntermediate_level_2_A pojoIntermediate_level_2_a){
    intermediateLvl2AAdapter = new Intermediate_lvl_2_A_Adapter(Intermediate2Activity.this,pojoIntermediate_level_2_a);
    Intr_lvl_2_RV.setAdapter(intermediateLvl2AAdapter);
}
}