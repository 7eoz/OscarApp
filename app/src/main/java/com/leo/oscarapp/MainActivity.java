package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sairButton, filmeButton, diretorButton, votoButton;
    TextView tokenField;
    int idFilme, idDiretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idFilme = extras.getInt("filme");
            idDiretor = extras.getInt("diretor");
        }

        filmeButton = findViewById(R.id.votarFilme);
        diretorButton = findViewById(R.id.votarDiretor);
        votoButton = findViewById(R.id.confirmarVoto);
        sairButton = findViewById(R.id.sairBtn);
        tokenField = findViewById(R.id.token);

        //---------------------------------------//
        // SETAR NUMERO DO TOKEN AQUI:
        tokenField.setText("Token: "+"000");
        //---------------------------------------//

        filmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VoteMovieActivity.class);
                intent.putExtra("filme",idFilme);
                startActivity(intent);
            }
        });
        diretorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //---------------------------------------//
                // SETAR ACTIVITY DE DIRETOR AQUI:

                //Intent intent = new Intent(MainActivity.this, <NOME DA ACTIVITY>.class);
                //startActivity(intent);

                //RETORNAR ID DE DIRETOR PARA VARIAVEL : idDiretor
                //---------------------------------------//
            }
        });
        votoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("filme",idFilme);
                intent.putExtra("diretor",idDiretor);
                startActivity(intent);


            }
        });

        sairButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT",true);
            startActivity(intent);
        });

    }
}