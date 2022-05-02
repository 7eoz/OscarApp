package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.leo.oscarapp.api.LoginRequest;
import com.leo.oscarapp.api.LoginResponse;
import com.leo.oscarapp.api.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                login();
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

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(login.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = new RetrofitConfig().getUserService().userLogin(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data",loginResponse.getUsername()))
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    },700);

                }else{
                    Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(),"Throwable "+t.getLocalizedMessage() + " ", Toast.LENGTH_LONG).show();
            }
        });
    }

}