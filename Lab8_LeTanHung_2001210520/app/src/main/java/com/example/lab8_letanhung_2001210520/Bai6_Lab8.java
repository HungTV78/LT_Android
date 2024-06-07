package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Bai6_Lab8 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6_lab8);

        initData();

        // Khởi tạo RecyclerView và Adapter
        recyclerView = findViewById(R.id.recyclerView);
        songAdapter = new SongAdapter(this, songList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songAdapter);
    }

    private void initData() {
        songList = new ArrayList<>();

        // Đọc dữ liệu từ tệp XML
        try {
            InputStream is = getAssets().open("songs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("song");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String songName = element.getElementsByTagName("name").item(0).getTextContent();
                String singer = element.getElementsByTagName("singer").item(0).getTextContent();
                int imageResource = getResources().getIdentifier(element.getElementsByTagName("imageResource").item(0).getTextContent(), "drawable", getPackageName());
                int year = Integer.parseInt(element.getElementsByTagName("year").item(0).getTextContent());

                songList.add(new Song(songName, singer, imageResource, year));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
