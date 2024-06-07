package com.example.lab11_letanhung_2001210520;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    User selectedUser = null;

    Button btnInsert, btnDelete, btnUpdate;
    ListView lvKq;
    ArrayList<User>lsUser = new ArrayList<>();
    ArrayList<String>lsDataLV = new ArrayList<>();
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        FirebaseApp.initializeApp(this);
        // initData();
        getDataFromFirebase();
        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,lsDataLV);
        lvKq.setAdapter(adapter);

        addEvent();

    }
    ArrayList<String> convertToArrString(ArrayList<User> lsUs)
    {
        ArrayList<String>lsString=new ArrayList<>();
        for (User u:lsUs ) {
            String s = "Tên: " + u.getName() + " -  " + "Tuổi: "+String.valueOf(u.getAge());
            lsString.add(s);
        }
        return lsString;
    }
    public  void addControls()
    {
        edtName=(EditText) findViewById(R.id.edtName);
        edtAge=(EditText) findViewById(R.id.edtAge);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete=(Button) findViewById(R.id.btnDelete);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        lvKq = (ListView) findViewById(R.id.lvKq);
    }
    public void addEvent() {
        // Thiết lập sự kiện khi nhấn nút Insert
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("User");
                User u = new User(edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString()));

                String key = myRef.push().getKey();
                myRef.child("User" +(lsUser.size()+1)).setValue(u);
            }
        });

        // Thiết lập sự kiện khi nhấn nút Delete
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedUser != null) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("User");

                    // Tạo truy vấn để tìm và xóa người dùng được chọn
                    Query query = myRef.orderByChild("name").equalTo(selectedUser.getName());
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                                if (userSnapshot.child("age").getValue(Integer.class).equals(selectedUser.getAge())) {
                                    userSnapshot.getRef().removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Xử lý lỗi nếu có
                        }
                    });
                }
            }
        });

        // Thiết lập sự kiện khi nhấn nút Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedUser != null) {
                    // Lấy dữ liệu mới từ các EditText
                    String newName = edtName.getText().toString();
                    int newAge = Integer.parseInt(edtAge.getText().toString());

                    // Cập nhật dữ liệu trong Firebase
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("User");

                    Query query = myRef.orderByChild("name").equalTo(selectedUser.getName());
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                                if (userSnapshot.child("age").getValue(Integer.class).equals(selectedUser.getAge())) {
                                    // Cập nhật dữ liệu
                                    userSnapshot.getRef().child("name").setValue(newName);
                                    userSnapshot.getRef().child("age").setValue(newAge);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        lvKq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lưu trữ thông tin của mục được chọn
                selectedUser = lsUser.get(position);
                // Hiển thị thông tin của mục được chọn lên các EditText
                edtName.setText(selectedUser.getName());
                edtAge.setText(String.valueOf(selectedUser.getAge()));
            }
        });
    }


    public  void initData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        for(int i=0;i<5; i++) {
            User user = new User("Ten " + i, 15+i);
            myRef.child("User_" +i).setValue(user);//thêm push để tạo mục có key random, ko bị đè khi bị trùng

        }
    }
    public void getDataFromFirebase ()
    {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lsUser.clear();
                for (DataSnapshot userSnapshot: snapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    lsUser.add(user);
                }
                lsDataLV = convertToArrString(lsUser);
                adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,lsDataLV);
                lvKq.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}