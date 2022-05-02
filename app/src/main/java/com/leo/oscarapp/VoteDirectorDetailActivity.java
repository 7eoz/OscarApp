package com.leo.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VoteDirectorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_director_detail);
        TextView t =findViewById(R.id.directorNameDetail);

        t.setText(getIntent().getStringExtra("nome"));
    }
}