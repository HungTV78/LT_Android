package com.example.lab10_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    TextView textViewAlbum; // Renamed for consistency
    ListView lvAlbum;
    CustomAdapterArtist adapterArtist;
    ArrayList<Album> lsAlb = new ArrayList<>();
    String url="https://soundiiz.com/data/fileExamples/albumsExport.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        textViewAlbum = findViewById(R.id.tvAlbum);
        lvAlbum = findViewById(R.id.lvAlbum);
        getAllDataArtist(url);
    }

    public void getAllDataArtist(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(AlbumActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            albumJsonData(response);
                            CustomAdapterAlbum adapterAlbum = new CustomAdapterAlbum(AlbumActivity.this, R.layout.album_item, lsAlb);
                            lvAlbum.setAdapter(adapterAlbum);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    public void albumJsonData(String response) throws JSONException {
        JSONArray albumArray = new JSONArray(response);
        for (int i = 0; i < albumArray.length(); i++) {
            JSONObject album = albumArray.getJSONObject(i);
            Album p = new Album();
            p.setTitle(album.getString("title"));
            p.setArtist(album.getString("artist"));
            p.setNumberOfTracks(album.getInt("num"));
            p.setPicture(album.getString("picture"));
            lsAlb.add(p);
        }
    }
}
