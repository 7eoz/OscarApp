package com.leo.oscarapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMovieList extends ArrayAdapter {
    private String[] movieList;
    private String[] genderList;
    private Integer[] imageid;
    private Activity context;

    public CustomMovieList(Activity context, String[] movieList, String[] genderList, Integer[] imageid) {
        super(context, R.layout.row_item, movieList);
        this.context = context;
        this.movieList = movieList;
        this.genderList = genderList;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewCountry = (TextView) row.findViewById(R.id.textViewCountry);
        TextView textViewCapital = (TextView) row.findViewById(R.id.textViewCapital);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.imageViewFlag);

        textViewCountry.setText(movieList[position]);
        textViewCapital.setText(genderList[position]);
        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}
