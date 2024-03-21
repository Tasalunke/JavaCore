package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class SplashActivity extends AppCompatActivity {
    TextView txt_view;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txt_view =findViewById(R.id.txt_view);
        lottie=findViewById(R.id.lottie);

        lottie.animate().translationX(2000).setDuration(3000).setStartDelay(2900);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        },5000);
    }
}