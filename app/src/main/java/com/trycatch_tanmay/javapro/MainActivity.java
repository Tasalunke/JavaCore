package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    ImageView chp,tpc,prmg,inteve,quiz;
    TextView chp_1,tpc_1,prmg_1,inteve_1,quiz1;
    CardView card1,Card3,Card4,Card5,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chp = findViewById(R.id.chp);
        tpc = findViewById(R.id.tpc);
        prmg = findViewById(R.id.prmg);
        inteve = findViewById(R.id.inteve);

//        TextView id
        chp_1 = findViewById(R.id.chp_1);
        tpc_1 = findViewById(R.id.tpc_1);
        prmg_1 = findViewById(R.id.prmg_1);
        inteve_1 = findViewById(R.id.inteve_1);

//        Card view id
        card1=findViewById(R.id.card1);
        Card3= findViewById(R.id.Card3);
        Card4= findViewById(R.id.Card4);
        card2=findViewById(R.id.card2);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));
//        Pass intent for Topics activity
      card1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this,ChapterActivity.class);
              startActivity(intent);
          }
      });
//        Pass intent for Quiz activity
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
        Card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,InterViewQuestionActivity.class);
                startActivity(intent);
            }
        });
        Card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ProgramActivity.class);
                startActivity(intent);
            }
        });
    }
}