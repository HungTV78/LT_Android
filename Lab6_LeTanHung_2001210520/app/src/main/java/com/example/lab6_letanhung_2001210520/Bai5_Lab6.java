package com.example.lab6_letanhung_2001210520;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import androidx.appcompat.view.menu.MenuBuilder;

public class Bai5_Lab6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab6);

        Toolbar toolbar = findViewById(R.id.toolbar_bai5);
        setSupportActionBar(toolbar);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bai5, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menuitem_android)
        {
            Toast.makeText(getApplicationContext(),"Android",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_profile)
        {
            Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_dowload)
        {
            Toast.makeText(getApplicationContext(),"Dowload",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_setting)
        {
            Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_exit)
        {
            Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}