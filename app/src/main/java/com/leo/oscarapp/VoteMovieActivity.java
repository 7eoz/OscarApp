package com.leo.oscarapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.leo.oscarapp.util.GetMovies;

import java.util.HashMap;

public class VoteMovieActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private ListView movieList;
    private static String url = "https://dl.dropboxusercontent.com/s/luags6sv8uxdoj1/filme.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie);

        movieList = findViewById(R.id.movieList);
        progressDialog = new ProgressDialog(this);
        new GetMovies(progressDialog, movieList, getApplicationContext()).execute(url);
        movieList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(VoteMovieActivity.this, VoteDirectorDetailActivity.class);
            HashMap<String, Object> obj = (HashMap<String, Object>) movieList.getAdapter().getItem(i);
            intent.putExtra("nome",movieList.getAdapter().getItem(i).toString());
            startActivity(intent);
        });
    }

}