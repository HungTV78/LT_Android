package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bai3_Child_Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_child_lab3);

        TextView txtName = findViewById(R.id.txt_name);
        TextView txtEmail = findViewById(R.id.txt_email);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String email = extras.getString("email");

            txtName.setText("Name: " + name);
            txtEmail.setText("Email: " + email);
        }
    }
}
