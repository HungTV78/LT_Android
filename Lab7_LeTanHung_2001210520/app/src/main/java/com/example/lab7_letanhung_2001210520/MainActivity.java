package com.example.lab7_letanhung_2001210520;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.view.menu.MenuBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tvCM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCM = findViewById(R.id.tvCM);
        registerForContextMenu(tvCM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu_1, menu);

        MenuItem facebookItem = menu.findItem(R.id.menuitem_facebook);
        if (facebookItem != null) {
            facebookItem.setIcon(R.drawable.facebook_icon);
        }

        MenuItem deleteItem = menu.findItem(R.id.menuitem_delete);
        if (deleteItem != null) {
            deleteItem.setIcon(R.drawable.baseline_delete_24);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.menuitem_facebook)
        {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.menuitem_delete)
        {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //Xử lý của Context Menu (Lab7)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu1, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        if(id==R.id.ci_insert)
        {
            Toast.makeText(this, "Insert", Toast.LENGTH_SHORT).show();
        }
        else  if(id==R.id.ci_delete)
        {
            Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
