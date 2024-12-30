package com.example.wizquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.widget.ImageView;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Apply system bar insets to the main layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the database
        database = AppDatabase.getInstance(this);

        // Set up the Flashcards button
        Button btnFlashcards = findViewById(R.id.btn_flashcards);
        btnFlashcards.setOnClickListener(v -> {
            try {
                Log.d("HomeActivity", "Flashcard button clicked");

                // Navigate to FlashcardActivity
                Intent intent = new Intent(HomeActivity.this, FlashcardActivity.class);
                startActivity(intent);

            } catch (Exception e) {
                Log.e("HomeActivity", "Error launching FlashcardActivity", e);
                Toast.makeText(HomeActivity.this, "Error opening FlashcardActivity", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView profileImageView = findViewById(R.id.profileImageView);
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open ProfileActivity when the image is clicked
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
