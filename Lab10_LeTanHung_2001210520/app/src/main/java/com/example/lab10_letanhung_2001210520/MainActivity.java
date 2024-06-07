package com.example.lab10_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {
    CustomAdapterArtist costomAdapterArtist;

    CustomAdapterPlaylist costomAdapterPlaylist;

    ArrayList<Artist> lsArt = new ArrayList<>();
    ArrayList<Playlist> lsPlaylist = new ArrayList<>();
    ArrayList<Album> lsAlb = new ArrayList<>();
    Button btn_Artist, btn_Album, btn_playlist;
    EditText edtIp;
    TextView textView;
    ListView lvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    void addControls()
    {
        btn_Artist = (Button) findViewById(R.id.btnArtist);
        btn_Album = (Button) findViewById(R.id.btnAlbum);
        btn_playlist = (Button) findViewById(R.id.btnPlaylist);
        edtIp = (EditText) findViewById(R.id.edtIp);
        lvKq=(ListView) findViewById(R.id.lvResult);
        textView=(TextView) findViewById(R.id.tvMessage);

    }
    void addEvents()
    {
        btn_Artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://soundiiz.com/data/fileExamples/artistsExport.json";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJsonData(response);
                        costomAdapterArtist=new CustomAdapterArtist(getApplicationContext(),R.layout.layout_item_artist,
                                lsArt);
                        lvKq.setAdapter(costomAdapterArtist);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        textView.setText("error");
                    }

                });

                queue.add(stringRequest);
            }
        });

        btn_Album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String ip = edtIp.getText().toString();
                String url = "https://my-json-server.typicode.com/typicode/demo/posts/" + ip;

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        albumJsonData(response);
                        CustomAdapterAlbum customAdapterAlbum = new CustomAdapterAlbum(getApplicationContext(), R.layout.album_item, lsAlb);
                        lvKq.setAdapter(customAdapterAlbum);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        textView.setText("error");
                    }

                });

                queue.add(stringRequest);
            }
        });


        btn_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String url = "https://soundiiz.com/data/fileExamples/playlistExport.json";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        playlistJsonData(response);
                        costomAdapterPlaylist=new CustomAdapterPlaylist(getApplicationContext(),R.layout.playlist_item,
                                lsPlaylist);
                        lvKq.setAdapter(costomAdapterPlaylist);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        textView.setText("error");
                    }
                });

                queue.add(stringRequest);
            }
        });

    }
    public void  parseJsonData(String response){
        try{
            JSONArray artistArray  = new JSONArray(response);
            for(int i=0;i<artistArray.length();i++)
            {
                JSONObject artist= artistArray.getJSONObject(i);
                Artist a  =new Artist();
                a.name = artist.getString("name");
                a.numberFans = artist.getString("fans");
                a.piclink = artist.getString("picture");
                lsArt.add(a);
            }

        }
        catch (JSONException e){
            throw   new RuntimeException(e);
        }
    }
    public void albumJsonData(String response) {
        try {
            JSONArray albumArray = new JSONArray(response);
            for (int i = 0; i < albumArray.length(); i++) {
                JSONObject albumJson = albumArray.getJSONObject(i);
                Album album = new Album();
                if (albumJson.has("title")) {
                    album.setTitle(albumJson.getString("title"));
                }
                if (albumJson.has("artist")) {
                    album.setArtist(albumJson.getString("artist"));
                }
                if (albumJson.has("number of tracks")) {
                    album.setNumberOfTracks(albumJson.getInt("number of tracks"));
                }
                if (albumJson.has("picture")) {
                    album.setPicture(albumJson.getString("picture"));
                }
                lsAlb.add(album);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void playlistJsonData(String response) {
        try{
            JSONArray playlistArray  = new JSONArray(response);
            for(int i=0;i<playlistArray.length();i++)
            {
                JSONObject playlist=  playlistArray.getJSONObject(i);
                Playlist p  = new Playlist();
                p.setTitle(playlist.getString("title"));
                p.setArtist(playlist.getString("artist"));
                p.setAlbum(playlist.getString("album"));
                p.setPicture(playlist.getString("picture"));
                lsPlaylist.add(p);
            }

        }
        catch (JSONException e){
            throw   new RuntimeException(e);
        }
    }

}
