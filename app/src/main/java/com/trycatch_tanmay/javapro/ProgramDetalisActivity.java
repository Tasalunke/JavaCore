package com.trycatch_tanmay.javapro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class ProgramDetalisActivity extends AppCompatActivity {

    TextView chapterTextView, subtopicTextView, contentTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detalis);

        chapterTextView = findViewById(R.id.chapterTextView);
        subtopicTextView = findViewById(R.id.subtopicTextView);
        contentTextView = findViewById(R.id.contentTextView);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.purple_100))));

        String programName = getIntent().getStringExtra("programName");
        String programContent = getIntent().getStringExtra("programContent");

        // Find views
        TextView subtopicTextView = findViewById(R.id.subtopicTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);

        // Set program name and content in the views
        subtopicTextView.setText(programName);
        contentTextView.setText(programContent);
    }
}