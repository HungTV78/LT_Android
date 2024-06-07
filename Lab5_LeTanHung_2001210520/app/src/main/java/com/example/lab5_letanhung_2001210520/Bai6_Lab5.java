package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import java.util.ArrayList;

public class Bai6_Lab5 extends AppCompatActivity {

    Spinner spinner_language;
    ArrayList<Language_Bai6> arrayListLanguage = new ArrayList<>();
    CustomAdapter_Bai6 adapterLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6_lab5);

        int[] lsIdImg = new int[]{R.drawable.c, R.drawable.html, R.drawable.xml, R.drawable.php};
        String[] lsName = new String[]{"C# Language", "HTML Language", "XML Language", "PHP Language"};

        spinner_language = findViewById(R.id.spinner_language);
        arrayListLanguage = Language_Bai6.initArrayListLanguage(lsIdImg, lsName);
        adapterLanguage = new CustomAdapter_Bai6(this, R.layout.layout_item_bai6, R.id.tvName, arrayListLanguage, spinner_language);
        spinner_language.setAdapter(adapterLanguage);
    }
}
