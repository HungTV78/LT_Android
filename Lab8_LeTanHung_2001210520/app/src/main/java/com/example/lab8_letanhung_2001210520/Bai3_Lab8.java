package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.util.Xml;

public class Bai3_Lab8 extends AppCompatActivity {
    Button btnReadXml, btnWriteXml;
    TextView tvContent2;
    ArrayList<NhanVien> arrayListNV=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab8);

        addControls();
        addEvents();
    }

    private void addControls()
    {
        btnReadXml = findViewById(R.id.btnRead);
        btnWriteXml = findViewById(R.id.btnSave);
        tvContent2 = findViewById(R.id.tvContent2);
    }

    private void addEvents() {
        btnReadXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDSNV();
                String kq = "";
                for (NhanVien nv : arrayListNV) {
                    kq += nv.printNV();
                }
                tvContent2.setText(kq);
            }
        });

        btnWriteXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeDSNV();
            }
        });
    }

    // Hàm đọc dữ liệu từ file xml đưa vào arrayListNV
    public void readDSNV() {
        try {
            InputStream inputStream = openFileInput("dsnv.xml");
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(inputStream, "UTF-8");
            int tagType = -1;
            String nodeName;

            while (tagType != XmlPullParser.END_DOCUMENT) {
                tagType = parser.next();
                switch (tagType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        nodeName = parser.getName();
                        if (nodeName.equals("nv")) {
                            NhanVien nv = new NhanVien();
                            while (tagType != XmlPullParser.END_TAG) {
                                tagType = parser.next();
                                nodeName = parser.getName();
                                if (tagType == XmlPullParser.START_TAG) {
                                    if (nodeName.equals("msnv")) {
                                        nv.setMsnv(parser.nextText());
                                    } else if (nodeName.equals("ten")) {
                                        nv.setTen(parser.nextText());
                                    } else if (nodeName.equals("sdt")) {
                                        nv.setSdt(parser.nextText());
                                    } else if (nodeName.equals("chucvu")) {
                                        nv.setChucvu(parser.nextText());
                                    }
                                }
                            }
                            arrayListNV.add(nv);
                        }
                        break;
                }
            }
            inputStream.close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm ghi ds nhân viên xuống file xml
    public void writeDSNV() {
        try {
            OutputStream outputStream = openFileOutput("dsnv2.xml", MODE_PRIVATE);
            XmlSerializer xmlSerializer = Xml.newSerializer();
            xmlSerializer.setOutput(outputStream, "UTF-8");
            xmlSerializer.startDocument("UTF-8", true);
            xmlSerializer.startTag(null, "dsnv");

            for (int i = 0; i < arrayListNV.size(); i++) {
                NhanVien nv = arrayListNV.get(i);
                xmlSerializer.startTag(null, "nv");
                xmlSerializer.startTag(null, "msnv");
                xmlSerializer.text(nv.getMsnv());
                xmlSerializer.endTag(null, "msnv");
                xmlSerializer.startTag(null, "ten");
                xmlSerializer.text(nv.getTen());
                xmlSerializer.endTag(null, "ten");
                xmlSerializer.startTag(null, "sdt");
                xmlSerializer.text(nv.getSdt());
                xmlSerializer.endTag(null, "sdt");
                xmlSerializer.startTag(null, "chucvu");
                xmlSerializer.text(nv.getChucvu());
                xmlSerializer.endTag(null, "chucvu");
                xmlSerializer.endTag(null, "nv");
            }

            xmlSerializer.endTag(null, "dsnv");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
