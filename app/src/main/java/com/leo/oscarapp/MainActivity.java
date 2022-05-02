package com.leo.oscarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

//    Button sairButton, filmeButton, diretorButton, votoButton;
//    TextView tokenField;
//    int idFilme, idDiretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            idFilme = extras.getInt("filme");
//            idDiretor = extras.getInt("diretor");
//        }

//        filmeButton = findViewById(R.id.votarFilme);
//        diretorButton = findViewById(R.id.votarDiretor);
//        votoButton = findViewById(R.id.confirmarVoto);
//        sairButton = findViewById(R.id.sairBtn);
//        tokenField = findViewById(R.id.token);

        //---------------------------------------//
        // SETAR NUMERO DO TOKEN AQUI:
//        tokenField.setText("Token: "+"000");
        //---------------------------------------//

//        filmeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, VoteMovieActivity.class);
//                intent.putExtra("filme",idFilme);
//                startActivity(intent);
//            }
//        });
//        diretorButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                //---------------------------------------//
                // SETAR ACTIVITY DE DIRETOR AQUI:

                //Intent intent = new Intent(MainActivity.this, <NOME DA ACTIVITY>.class);
                //startActivity(intent);

                //RETORNAR ID DE DIRETOR PARA VARIAVEL : idDiretor
                //---------------------------------------//
//            }
//        });
//        votoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
//                intent.putExtra("filme",idFilme);
//                intent.putExtra("diretor",idDiretor);
//                startActivity(intent);


//            }
//        });

//        sairButton.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.putExtra("EXIT",true);
//            startActivity(intent);
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.voteMovieButton) {
            Intent intent = new Intent(getApplicationContext(), VoteMovieActivity.class);
            startActivity(intent);
        } else if(item.getItemId() == R.id.voteDirectorButton) {
            Intent intent = new Intent(getApplicationContext(), VoteDirectorActivity.class);
            startActivity(intent);
        } else if(item.getItemId() == R.id.confirmVotesButton) {
            Intent intent = new Intent(getApplicationContext(), ConfirmVotesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}