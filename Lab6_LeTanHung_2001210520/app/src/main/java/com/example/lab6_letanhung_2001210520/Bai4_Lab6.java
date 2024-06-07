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

public class Bai4_Lab6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab6);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menuitem_facebook)
        {
            Toast.makeText(getApplicationContext(),"Facebook",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_instagram)
        {
            Toast.makeText(getApplicationContext(),"Instagram",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_delete)
        {
            Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_setting)
        {
            Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_share)
        {
            Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_open)
        {
            Toast.makeText(getApplicationContext(),"Open",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
