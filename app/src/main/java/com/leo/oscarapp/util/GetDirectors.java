package com.leo.oscarapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.leo.oscarapp.R;
import com.leo.oscarapp.VoteMovieActivity;
import com.leo.oscarapp.adapter.MovieAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDirectors extends AsyncTask<String, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private ListView listView;
    ArrayList<HashMap<String, String>> directorList;

    public GetDirectors(ProgressDialog progressDialog, ListView listView, Context context) {
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
        directorList = new ArrayList<>();

        //Do request and receives the answer
        String jsonStr = sh.makeServiceCall(strings[0]);
        if (jsonStr != null) {
            try {
                JSONArray directors = new JSONArray(jsonStr);
                //running array and getting teams
                for(int i = 0; i < directors.length(); i++) {
                    JSONObject object = directors.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.getString("nome");

                    HashMap<String, String> director = new HashMap<>();
                    director.put("id", id);
                    director.put("name", name);
                    directorList.add(director);
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
                directorList,
                R.layout.director_item,
                new String[]{"name"},
                new int[]{R.id.directorName}
        );
        listView.setAdapter(adapter);
    }

}
