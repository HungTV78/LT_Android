package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_danhmuc, spinner_traicay;
    ArrayList<Fruit> arrayListFruit = new ArrayList<>();
    CustomAdapterSpinner adapterFruit;

    int[] lsIdImg = new int[]{R.drawable.apple, R.drawable.banana, R.drawable.litchi, R.drawable.mango, R.drawable.pineapple};
    String[] lsName = new String[]{"Táo", "Chuối", "Dâu", "Xoài", "Thơm"};
    double[] lsPrice = new double[]{100, 12, 80, 20, 30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_traicay = findViewById(R.id.spinner_traicay);
        // Khởi tạo danh sách trái cây
        ArrayList<Fruit> arrayListFruit = Fruit.initArrayListFruit(lsIdImg, lsName, lsPrice);
        adapterFruit = new CustomAdapterSpinner(MainActivity.this, R.layout.layout_item_fruit, arrayListFruit);
        spinner_traicay.setAdapter(adapterFruit);
    }
}
