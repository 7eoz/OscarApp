package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmVotesActivity extends AppCompatActivity {

    Button envioVotoButton;
    TextView diretorText,filmeText,tokenInput;
    int idFilme, idDiretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_votes);
        diretorText = findViewById(R.id.diretorText);
        filmeText = findViewById(R.id.filmeText);
        tokenInput = findViewById(R.id.inputToken);
        envioVotoButton = findViewById(R.id.confirmaButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idFilme = extras.getInt("filme");
            idDiretor = extras.getInt("diretor");
        }

        //---------------------------------------//
        // FAZER LÓGICA DE CONEXÃO COM BD PARA PEGAR INFO DO FILME E DIRETOR

        //VARIAVEIS

        // idDiretor
        // idFilme


        filmeText.setText("Filme: "+"<COLOCAR NOME DO FILME AQUI>");
        diretorText.setText("Diretor: "+"<COLOCAR NOME DO DIRETOR AQUI>");
        //---------------------------------------//

        envioVotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean err= false;

                //---------------------------------------//
                //INSERIR LÓGICA DE ENVIO DE VOTO PARA BD AQUI (RETORNAR BOOLEAN PARA SUCESSO OU ERRO)

                //VARIAVEIS
                tokenInput.getText();   // Token
                // idDiretor
                // idFilme

                //err= <ENVIO DE VOTO PARA BD()>;

                //---------------------------------------//

                AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmVotesActivity.this);

                if (err)
                    builder.setMessage("Token invalido.")
                            .setTitle("Falha no envio!");
                else
                    builder.setMessage("Voto enviado com sucesso!");

                builder.setPositiveButton("OK",null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }
}