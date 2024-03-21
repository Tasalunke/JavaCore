package com.trycatch_tanmay.javapro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity implements QuizLevelAdapter.OnItemClickListener {
    RecyclerView nameRV;
    QuizLevelAdapter quizLevelAdapter;
    ArrayList<PojoQuizLevel> quizLevelList; // Declare the variable
    GifImageView gif2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        gif2 = findViewById(R.id.gif_panda2);
        nameRV = findViewById(R.id.nameRV);
        getLevel("");
        getWindow().setStatusBarColor(getColor(R.color.purple_100));
    }

    private void getLevel(String names) {
        Call<ArrayList<PojoQuizLevel>> call = ApiClient.getJavapro().getQuizLevel(names);
        call.enqueue(new Callback<ArrayList<PojoQuizLevel>>() {
            @Override
            public void onResponse(Call<ArrayList<PojoQuizLevel>> call, Response<ArrayList<PojoQuizLevel>> response) {
                if (response.code() == 200 && response.body() != null) {
                    gif2.setVisibility(View.GONE);
                    nameRV.setVisibility(View.VISIBLE);
                    quizLevelList = response.body(); // Assign the data to the variable
                    setupRecyclerView();
                } else if (response.code() == 401) {
                    Toast.makeText(QuizActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PojoQuizLevel>> call, Throwable t) {
                Toast.makeText(QuizActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        quizLevelAdapter = new QuizLevelAdapter(QuizActivity.this, quizLevelList, QuizActivity.this);
        nameRV.setLayoutManager(new LinearLayoutManager(QuizActivity.this));
        nameRV.setAdapter(quizLevelAdapter);
    }

    @Override
    public void onItemClick(String levelName) {
        // Handle item click based on the levelName
//        Toast.makeText(this, "Clicked on " + levelName, Toast.LENGTH_SHORT).show();

        // Start different activities based on the levelName
        switch (levelName) {
            case "Beginner 1":
                startActivity(new Intent(QuizActivity.this, Level1Activity.class));
                break;
            case "Beginner 2":
                startActivity(new Intent(QuizActivity.this, Leve2Activity.class));
                break;
            case "Beginner 3":
                startActivity(new Intent(QuizActivity.this, Level3Activity.class));
                break;
            case "Intermediate 1":
                startActivity(new Intent(QuizActivity.this,Intermediate1Activity.class));
                break;
            case "Intermediate 2":
                startActivity(new Intent(QuizActivity.this,Intermediate2Activity.class));
            // Add more cases for other levels if needed
        }
    }
}
