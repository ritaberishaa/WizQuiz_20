package com.example.wizquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText newPasswordEditText, confirmPasswordEditText;
    private Button resetPasswordButton;
    private DB DB;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Initialize elements
        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);

        // Get the email passed from CodeConfirmationActivity
        email = getIntent().getStringExtra("email");
        DB = new DB(this);

        // Set the reset password button logic
        resetPasswordButton.setOnClickListener(v -> {
            resetPassword();
        });
    }

    private void resetPassword() {
        String newPassword = newPasswordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (validateInput(newPassword, confirmPassword)) {
            // Update the password in the database
            if (DB.updatePassword(email, newPassword)) {
                Toast.makeText(this, "Password updated successfully!", Toast.LENGTH_SHORT).show();
                // Redirect to Login screen
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to update password. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validateInput(String newPassword, String confirmPassword) {
        if (TextUtils.isEmpty(newPassword) || newPassword.length() < 6) {
            newPasswordEditText.setError("Password must be at least 6 characters");
            return false;
        }

        if (TextUtils.isEmpty(confirmPassword) || !newPassword.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Passwords do not match");
            return false;
        }

        return true;
    }
}

