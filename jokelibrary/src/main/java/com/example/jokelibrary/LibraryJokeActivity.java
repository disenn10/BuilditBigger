package com.example.jokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryJokeActivity extends AppCompatActivity {
    TextView textView;
    static String JOKE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_joke);
        textView = findViewById(R.id.joke);
        JOKE = getIntent().getStringExtra("joke");
        textView.setText(JOKE);
    }
    public static String receivedJoke(){
        return JOKE;
    }
}
