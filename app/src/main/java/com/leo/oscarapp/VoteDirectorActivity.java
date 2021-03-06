package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.leo.oscarapp.util.GetDirectors;
import com.leo.oscarapp.util.GetMovies;

import java.util.HashMap;

public class VoteDirectorActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private ListView directorList;
    private static String url = "https://dl.dropboxusercontent.com/s/4scnaqzioi3ivxc/diretor.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_director);

        directorList = findViewById(R.id.directorList);
        progressDialog = new ProgressDialog(this);
        new GetDirectors(progressDialog, directorList, getApplicationContext()).execute(url);
        directorList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(VoteDirectorActivity.this, VoteDirectorDetailActivity.class);
            HashMap<String, Object> obj = (HashMap<String, Object>) directorList.getAdapter().getItem(i);
            intent.putExtra("nome",(String) obj.get("name"));
            startActivity(intent);
        });
    }
}