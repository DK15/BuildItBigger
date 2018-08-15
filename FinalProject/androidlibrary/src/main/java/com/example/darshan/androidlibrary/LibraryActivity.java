package com.example.darshan.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";

    TextView displayJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_main);

        displayJokeTextView = (TextView) findViewById(R.id.display_joke_tv);

        String jokeResult = null;

        Intent intent = getIntent();
        if (intent.hasExtra(JOKE_KEY)) {
            jokeResult = intent.getStringExtra(JOKE_KEY);
            displayJokeTextView.setText(jokeResult);
        } else {
            displayJokeTextView.setText(R.string.no_joke);
        }
    }
}
