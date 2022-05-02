package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VoteMovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie_detail);
        TextView t =findViewById(R.id.movieNameDetail);
        TextView g =findViewById(R.id.movieGenreText);
        ImageView i = findViewById(R.id.directorImageDetail);

        i.setImageURI(Uri.parse(getIntent().getExtras().getString("photo")));
        t.setText(getIntent().getExtras().getString("nome"));
        g.setText(getIntent().getExtras().getString("genero"));
    }
}