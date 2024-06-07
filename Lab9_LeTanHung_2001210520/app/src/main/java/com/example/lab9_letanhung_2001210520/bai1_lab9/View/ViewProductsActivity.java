package com.example.lab9_letanhung_2001210520.bai1_lab9.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab9_letanhung_2001210520.R;
import com.example.lab9_letanhung_2001210520.bai1_lab9.Model.Product;
import com.example.lab9_letanhung_2001210520.bai1_lab9.Controller.ProductHandler;

import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {
    EditText edtProductId, edtProductName, edtProductQuantity;
    Button btnAddProduct;
    ListView lvProducts;
    ArrayAdapter<Product> adapter;
    ProductHandler productHandler;


    ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        // Khởi tạo ProductHandler
        productHandler = new ProductHandler(this);

        // Ánh xạ các thành phần UI
        edtProductId = findViewById(R.id.edtProductId);
        edtProductName = findViewById(R.id.edtProductName);
        edtProductQuantity = findViewById(R.id.edtProductQuantity);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        lvProducts = findViewById(R.id.lvProducts);

        // Tạo ArrayAdapter để hiển thị dữ liệu lên ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productList);
        lvProducts.setAdapter(adapter);

        // Lấy danh sách sản phẩm từ cơ sở dữ liệu và hiển thị lên ListView
        productList.addAll(productHandler.getAllProducts());
        adapter.notifyDataSetChanged();

        // Xử lý sự kiện khi nhấn nút "Add Product"
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditTexts
                int id = Integer.parseInt(edtProductId.getText().toString());
                String name = edtProductName.getText().toString();
                int quantity = Integer.parseInt(edtProductQuantity.getText().toString());

                // Tạo sản phẩm mới
                Product newProduct = new Product(id, name, quantity);

                // Thêm sản phẩm vào cơ sở dữ liệu
                productHandler.addProduct(newProduct);

                // Cập nhật lại danh sách sản phẩm
                productList.clear();
                productList.addAll(productHandler.getAllProducts());
                adapter.notifyDataSetChanged();

                // Xóa nội dung các EditText sau khi thêm sản phẩm thành công
                edtProductId.setText("");
                edtProductName.setText("");
                edtProductQuantity.setText("");
            }
        });

        // Xử lý sự kiện khi chọn một sản phẩm trong ListView
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedProduct = productList.get(position);
                edtProductId.setText(String.valueOf(selectedProduct.getId()));
                edtProductName.setText(selectedProduct.getName());
                edtProductQuantity.setText(String.valueOf(selectedProduct.getQuantity()));
            }
        });
    }
}
