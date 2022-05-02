package com.leo.oscarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
//        if(item.getItemId() == R.id.itemSave){
//            ToDoDAO toDoDAO = new ToDoDAO(getApplicationContext());
//            if(currentToDo != null) { //edit
//                String strNewToDo = newToDo.getText().toString();
//                if (!strNewToDo.isEmpty()) {
//                    ToDo toDo = new ToDo();
//                    toDo.setToDoName(strNewToDo);
//                    toDo.setId(currentToDo.getId());
//                    //update DB
//                    if(toDoDAO.updateToDo(toDo)) {
//                        finish();
//                        Toast.makeText(this, "To Do updated", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(this, "Saving To Do error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            } else { //new to do
//                String strNewToDo = newToDo.getText().toString();
//                if (!strNewToDo.isEmpty()) {
//                    ToDo toDo = new ToDo();
//                    toDo.setToDoName(strNewToDo);
//                    if(toDoDAO.insertToDo(toDo)) {
//                        finish();
//                        Toast.makeText(this, "To Do saved", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(this, "Saving To Do error", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(this, "Insert a To Do", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
        return super.onOptionsItemSelected(item);
    }
}