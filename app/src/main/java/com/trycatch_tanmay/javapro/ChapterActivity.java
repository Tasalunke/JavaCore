package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import android.util.Log;
import android.view.View;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterActivity extends AppCompatActivity {
    RecyclerView chp_recyclerview;
    chpAdapter chpAdapter;
    GifImageView gif_panda2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        chp_recyclerview = findViewById(R.id.chp_recyclerview);
        gif_panda2=findViewById(R.id.gif_panda2);
        getTransData();
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
    }

    public void getTransData() {
        Call<ArrayList<chppojo>> call = ApiClient.getJavapro().gettransdata();
        call.enqueue(new Callback<ArrayList<chppojo>>() {
            @Override
            public void onResponse(Call<ArrayList<chppojo>> call, Response<ArrayList<chppojo>> response) {
                if (response.code() == 200 && response.body() != null) {
                    ArrayList<chppojo> data = response.body();
                    for (chppojo item : data) {
                        Log.d("ChapterActivity", "Chapter Name: " + item.getChapter().get(0).getChapterName());
                        List<Topic> subTopics = item.getTopic();
                        if (subTopics != null && !subTopics.isEmpty()) {
                            gif_panda2.setVisibility(View.GONE);
                            for (Topic subTopic : subTopics) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(SdkExtensions.AD_SERVICES) >= 4) {
                                    Log.d("ChapterActivity", "Subtopic Name: " + subTopic.getTopicId());
                                }
                            }
                        }
                    }
                    chpAdapter = new chpAdapter(ChapterActivity.this, data);
                    chp_recyclerview.setLayoutManager(new LinearLayoutManager(ChapterActivity.this));
                    chp_recyclerview.setAdapter(chpAdapter);
                } else if (response.code() == 401) {
                    Toast.makeText(ChapterActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChapterActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<chppojo>> call, Throwable t) {
                Toast.makeText(ChapterActivity.this, "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
