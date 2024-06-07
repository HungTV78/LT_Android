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

public class PlaylistActivity extends AppCompatActivity {
    TextView tvPlaylist;
    ListView lvPlaylist;
    CustomAdapterPlaylist adapterPlaylist;
    ArrayList<Playlist> lsPlaylist = new ArrayList<>();
    String url = "https://soundiiz.com/data/fileExamples/playlistExport.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        tvPlaylist = findViewById(R.id.tvPlaylist);
        lvPlaylist = findViewById(R.id.lvPlaylist);

        getAllDataPlaylist(url);
    }

    public void getAllDataPlaylist(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(PlaylistActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            playlistJsonData(response);
                        } catch (JSONException e) {
                            // Handle JSON exception properly
                            Toast.makeText(getApplicationContext(), "Error parsing JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error properly
                Toast.makeText(getApplicationContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    public void playlistJsonData(String response) throws JSONException {
        JSONArray playlistArray = new JSONArray(response);
        for (int i = 0; i < playlistArray.length(); i++) {
            JSONObject playlistJson = playlistArray.getJSONObject(i);
            Playlist playlist = new Playlist();
            playlist.setTitle(playlistJson.getString("title"));
            playlist.setArtist(playlistJson.getString("artist"));
            playlist.setAlbum(playlistJson.getString("album"));
            playlist.setPicture(playlistJson.getString("picture"));
            lsPlaylist.add(playlist);
        }
        adapterPlaylist = new CustomAdapterPlaylist(getApplicationContext(), R.layout.playlist_item, lsPlaylist);
        lvPlaylist.setAdapter(adapterPlaylist);
    }
}
