package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class ChpDetalisActivity extends AppCompatActivity {

    TextView chapterTextView, subtopicTextView, contentTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_detalis);


        chapterTextView = findViewById(R.id.chapterTextView);
        subtopicTextView = findViewById(R.id.subtopicTextView);
        contentTextView = findViewById(R.id.contentTextView);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));

//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ChpDetalisActivity.this, ChapterActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//12 345 78910112131415
//
        Intent intent = getIntent();
        if (intent != null) {
//            String topicId = intent.getStringExtra("topic_id");
            String subtopicName = intent.getStringExtra("subtopic");
            String content = intent.getStringExtra("content");

            // Update UI with subtopic and content
            if (subtopicName != null) {
                subtopicTextView.setText(subtopicName);

                // Check if content is not null before setting it
                if (content != null) {
                    contentTextView.setText(content);
                }
            }
        }
    }
}