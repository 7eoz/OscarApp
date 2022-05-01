package com.leo.oscarapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VoteMovieActivity extends AppCompatActivity {

    private ListView listView;
    private String movieList[] = {
            "Eu sou a Lenda",
            "7 vidas",
            "O pequenino",
            "A entidade"
    };

    private String genderList[] = {
            "Ação",
            "Drama",
            "Comédia",
            "Terror"
    };

    private Integer imageid[] = {
            R.drawable.oscars_2020,
            R.drawable.oscars_2020,
            R.drawable.oscars_2020,
            R.drawable.oscars_2020
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie);

        // Setting header
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("Vote Movie");

        ListView listView=findViewById(R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomMovieList customMovieList = new CustomMovieList(this, movieList, genderList, imageid);
        listView.setAdapter(customMovieList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+movieList[position-1]+ " as the best Movie",Toast.LENGTH_SHORT).show();        }
        });
    }

}