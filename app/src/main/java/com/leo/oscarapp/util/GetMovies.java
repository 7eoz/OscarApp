package com.leo.oscarapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.leo.oscarapp.R;
import com.leo.oscarapp.adapter.MovieAdapter;
import com.leo.oscarapp.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetMovies extends AsyncTask<String, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private ListView listView;
    ArrayList<HashMap<String, String>> movieList;

    public GetMovies(ProgressDialog progressDialog, ListView listView, Context context) {
        this.progressDialog = progressDialog;
        this.listView = listView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
        movieList = new ArrayList<>();

        //Do request and receives the answer
        String jsonStr = sh.makeServiceCall(strings[0]);
        if (jsonStr != null) {
            try {
//                JSONObject jsonObject = new JSONObject(jsonStr);
//                JSONArray movies = jsonObject.getJSONArray("filme");
                JSONArray movies = new JSONArray(jsonStr);
                //running array and getting teams
                for(int i = 0; i < movies.length(); i++) {
                    JSONObject object = movies.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.getString("nome");
                    String genre = object.getString("genero");
                    String photo = object.getString("foto");

                    HashMap<String, String> movie = new HashMap<>();
                    movie.put("id", id);
                    movie.put("name", name);
                    movie.put("genre", genre);
                    movie.put("photo", photo);
                    movieList.add(movie);
                } //final for
            }catch (final JSONException e) {
                e.printStackTrace();
            }
        } //final if
        return null;
    } //final doInBackground

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        ListAdapter adapter = new SimpleAdapter(
                context,
                movieList,
                R.layout.movie_item,
                new String[]{"name", "genre", "photo"},
                new int[]{R.id.movieName, R.id.movieGenre, R.id.movieImage}
        );
        listView.setAdapter(adapter);

//        MovieAdapter movieAdapter = new MovieAdapter((List<Movie>)movieList);
//        listView.setAdapter(movieAdapter);
//        listView.setAdapter(adapter);
    }
}
