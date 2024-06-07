package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Bai5_Lab8 extends AppCompatActivity {
    private TextView textView;
    private ListView listView;
    private Button btnDulieuTxt;
    private Button btnDulieuJson;
    private Button btnDulieuXml;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> storyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab8);

        textView = findViewById(R.id.tv_storyList);
        listView = findViewById(R.id.listView);
        btnDulieuTxt = findViewById(R.id.btn_dulieutxt);
        btnDulieuJson = findViewById(R.id.btn_dulieujson);
        btnDulieuXml = findViewById(R.id.btn_dulieuxml);

        storyList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storyList);
        listView.setAdapter(adapter);

        btnDulieuTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load data from truyencuoi.txt
                clearAndReadStoriesFromFile("truyencuoi.txt");
            }
        });

        btnDulieuJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load data from b.json
                clearAndReadStoriesFromJsonFile("b.json");
            }
        });

        btnDulieuXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load data from dssp.xml
                clearAndReadStoriesFromXmlFile("dssp.xml");
            }
        });
    }

    // Method to clear existing data and read data from txt file
    private void clearAndReadStoriesFromFile(String fileName) {
        clearStoryList();
        readStoriesFromFile(fileName);
    }

    // Method to clear existing data and read data from JSON file
    private void clearAndReadStoriesFromJsonFile(String fileName) {
        clearStoryList();
        readStoriesFromJsonFile(fileName);
    }

    // Method to clear existing data and read data from XML file
    private void clearAndReadStoriesFromXmlFile(String fileName) {
        clearStoryList();
        readStoriesFromXmlFile(fileName);
    }

    // Method to clear existing story list
    private void clearStoryList() {
        storyList.clear();
        adapter.notifyDataSetChanged();
    }

    // Method to read data from txt file and create a list of stories
    private void readStoriesFromFile(String fileName) {
        try {
            InputStream inputStream = getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                storyList.add(line);
            }
            bufferedReader.close();
            adapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read data from JSON file and create a list of stories
    private void readStoriesFromJsonFile(String fileName) {
        try {
            InputStream inputStream = getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("dscs");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject storyObject = jsonArray.getJSONObject(i);
                String title = storyObject.getString("hten");
                String content = storyObject.getString("qgia") + " - " + storyObject.getString("loai");
                storyList.add(title + "\n" + content);
            }
            adapter.notifyDataSetChanged();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Method to read data from XML file and create a list of stories
    private void readStoriesFromXmlFile(String fileName) {
        try {
            InputStream inputStream = getAssets().open(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("sp");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("tensp").item(0).getTextContent();
                    String content = element.getElementsByTagName("msp").item(0).getTextContent() + " - " + element.getElementsByTagName("dgia").item(0).getTextContent();
                    storyList.add(title + "\n" + content);
                }
            }
            adapter.notifyDataSetChanged();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
