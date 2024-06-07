package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Bai7_Lab8 extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7_lab8);

        editTextUsername = findViewById(R.id.edtUsername);
        editTextPassword = findViewById(R.id.edtPassword);
        buttonLogin = findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên người dùng và mật khẩu từ EditText
                final String username = editTextUsername.getText().toString().trim();
                final String password = editTextPassword.getText().toString().trim();

                if (isValid(username, password)) {
                    Intent intent = new Intent(Bai7_Lab8.this, DSNV.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Bai7_Lab8.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValid(String username, String password) {
        try {
            InputStream is = getAssets().open("taikhoan.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            // Lấy danh sách các nút tk
            NodeList nodeList = doc.getElementsByTagName("tk");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Lấy giá trị của us và pw từ mỗi tk
                    String us = element.getElementsByTagName("us").item(0).getTextContent();
                    String pw = element.getElementsByTagName("pw").item(0).getTextContent();
                    // So sánh với thông tin người dùng nhập
                    if (username.equals(us) && password.equals(pw)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}