package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import java.util.List;

public class Bai5_Lab5 extends AppCompatActivity {

    private Spinner spinner;
    private List<Language> languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab5);

        this.languages = Language.getLanguages();
        this.spinner = (Spinner) this.findViewById(R.id.spinner_language);
        CustomAdapterBai5 adapter = new CustomAdapterBai5(Bai5_Lab5.this,
                R.layout.spinner_item_layout_resource,
                R.id.textView_item_name,
                R.id.textView_item_percent,
                this.languages);
        this.spinner.setAdapter(adapter);
    }
}