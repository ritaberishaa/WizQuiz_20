package com.example.wizquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private DB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Initialize UI elements
        emailEditText = findViewById(R.id.emailEditText);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);
        DB = new DB(this);

        resetPasswordButton.setOnClickListener(v -> handlePasswordReset());
    }

    private void handlePasswordReset() {
        String email = emailEditText.getText().toString().trim();

        // Check if the email exists
        if (email.isEmpty()) {
            emailEditText.setError("Email cannot be empty");
        } else if (!DB.checkEmail(email)) {
            Toast.makeText(this, "No account found with this email", Toast.LENGTH_SHORT).show();
        } else {
            // Navigate to CodeConfirmationActivity to verify user identity
            Intent intent = new Intent(ForgotPasswordActivity.this, CodeConfirmationActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("flow", "forgot_password");
            startActivity(intent);

        }
    }
}
