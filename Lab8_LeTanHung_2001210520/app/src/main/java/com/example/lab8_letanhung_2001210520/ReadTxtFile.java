package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadTxtFile extends AppCompatActivity {
    Button btnReadTxt, btnWriteTxt;
    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_txt_file);
        Intent intent=getIntent();
        //Gắn id cho các controls
        addControls();
        //Xử lý các sự kiên
        addEvents();
    }
    private void addControls()
    {
        btnReadTxt=(Button) findViewById(R.id.btnReadTxt);
        btnWriteTxt=(Button) findViewById(R.id.btnWriteTxt);
        tvContent=(TextView) findViewById(R.id.tvContent);
    }
    private void addEvents() {
        btnReadTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ĐỌc dữ liệu từ assets
                try {
                    InputStream inputStream=openFileInput("test.txt");

                    int size=inputStream.available();
                    byte[] data=new byte[size];
                    inputStream.read(data);
                    inputStream.close();
                    String  stKq=new String(data);
                    tvContent.setText(stKq);
                    //thêm scrollbar


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        btnWriteTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStream outputStream=openFileOutput("test.txt",MODE_APPEND);//ghi nối vào file nếu file có rồi
                    String st=tvContent.getText().toString();
                    outputStream.write(st.getBytes());
                    outputStream.close();

                    Toast.makeText(getApplicationContext(),"ghi thành công",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}