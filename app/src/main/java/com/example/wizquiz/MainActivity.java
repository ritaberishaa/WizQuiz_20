package com.example.wizquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout i aktivitetit kryesor

        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText("Mirë se erdhët në WizQuiz!");
    }
}
