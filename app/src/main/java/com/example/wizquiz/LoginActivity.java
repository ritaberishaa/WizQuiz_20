package com.example.wizquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvSignUpLink; // opsional, p.sh. për të hapur SignUpActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // lidh layout-in e login

        // Lidhet me elementët e layout-it
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        tvSignUpLink = findViewById(R.id.tvSignUpLink);

        // Veprimi kur klikon “Login”
        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Këtu shto logjikën e verifikimit. Shembull i thjeshtë:
            if (username.equals("admin") && password.equals("1234")) {
                // Hyrje e suksesshme
                Toast.makeText(this, "Hyrje e suksesshme!", Toast.LENGTH_SHORT).show();

                // Kalo te MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                // Mbyll LoginActivity që të mos kthehesh pas me 'Back'
                finish();
            } else {
                Toast.makeText(this, "Username ose Password gabim!", Toast.LENGTH_SHORT).show();
            }
        });

        // Nëse ke një aktivitet tjetër për regjistrim
        tvSignUpLink.setOnClickListener(view -> {
            // startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            Toast.makeText(this, "Klik Regjistrohu!", Toast.LENGTH_SHORT).show();
        });
    }
}
