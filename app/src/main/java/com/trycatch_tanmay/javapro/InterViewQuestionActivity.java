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

public class InterViewQuestionActivity extends AppCompatActivity {
RecyclerView Interview_RV;
InterViewAdapter interViewAdapter;
    GifImageView gif2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_view_question);
        Interview_RV=findViewById(R.id.Interview_RV);
        getQuestionandAnswer();
        gif2=findViewById(R.id.gif_panda2);
        getWindow().setStatusBarColor(getColor(R.color.purple_100));
    }

    private void getQuestionandAnswer(){
        Call <ArrayList<PojoInterview>> call=ApiClient.getJavapro().getInterviewData();
      call.enqueue(new Callback<ArrayList<PojoInterview>>() {
          @Override
          public void onResponse(Call<ArrayList<PojoInterview>> call, Response<ArrayList<PojoInterview>> response) {
              if (response.code() ==200 && response.body()!=null){
                  gif2.setVisibility(View.GONE);
                  Interview_RV.setVisibility(View.VISIBLE);
                  InterViewAdapter interViewAdapter1 =new InterViewAdapter(InterViewQuestionActivity.this,response.body());
                  Interview_RV.setLayoutManager(new LinearLayoutManager(InterViewQuestionActivity.this));
                  Interview_RV.setAdapter(interViewAdapter1);
              }else if (response.code()==400){
                  Toast.makeText(InterViewQuestionActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(InterViewQuestionActivity.this, "Aunthorized", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<ArrayList<PojoInterview>> call, Throwable t) {
              Toast.makeText(InterViewQuestionActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
          }
      });

    }
}