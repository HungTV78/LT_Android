package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Bai1 extends AppCompatActivity {
    String tag="Events";
    /* Called when the activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Log.d(tag, "In the onCreate() event");
        Toast.makeText (getApplicationContext(),"onCreate()",Toast.LENGTH_SHORT).show();
    }
    public void onStart() { super.onStart();
        Log.d(tag, "In the onStart() event"); Toast.makeText (getApplicationContext(),"onStart()",Toast.LENGTH_SHORT).show(); }
    public void onRestart(){ super.onRestart();
        Log.d(tag,"In the onRestart() event"); Toast.makeText (getApplicationContext(),"onRestart()",Toast.LENGTH_SHORT).show();
    }
    public void onResume(){
        super.onResume();
        Log.d(tag, "In the onResume() event"); Toast.makeText (getApplicationContext()," onResume()",Toast.LENGTH_SHORT).show();
    }
    public void onPause(){
        super.onPause();
        Log.d(tag, "In the onPause() event"); Toast.makeText (getApplicationContext(),"onPause()",Toast.LENGTH_SHORT).show();
    }
    public void onStop(){
        super.onStop();
        Log.d(tag, "In the onStop() event"); Toast.makeText (getApplicationContext(),"onStop()",Toast.LENGTH_SHORT).show();
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag, "In the onStop() event"); Toast.makeText (getApplicationContext(),"onStop()",Toast.LENGTH_SHORT).show();
    }
}