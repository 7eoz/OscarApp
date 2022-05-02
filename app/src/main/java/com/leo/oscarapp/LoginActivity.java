package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText login, password;
    TextView forgotYourPassword, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //USADO PELO BOTÃO DE SAÍDA DA APLICAÇÃO
        //---------------------------------------//
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if(extras.getBoolean("EXIT")){
                finish();
                System.exit(0);
            }
        }
        //---------------------------------------//

        loginButton = findViewById(R.id.loginButton);
        login = findViewById(R.id.loginInput);
        password = findViewById(R.id.passwordInput);
        forgotYourPassword = findViewById(R.id.forgotYourPasswordLink);
        register = findViewById(R.id.registerLink);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        forgotYourPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}