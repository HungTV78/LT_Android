package com.example.lab9_letanhung_2001210520.bai3_lab9.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lab9_letanhung_2001210520.bai3_lab9.Model.SinhVien;

import java.util.ArrayList;

public class SinhVienHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "SinhVien.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "SinhVien";
    private static final String MSINHVIENn_COL = "maSV";
    private static final String TSINHVIEN_COL = "tenSV";
    public static String path = "/data/data/lab9_letanhung_2001210520/db/SinhVien.db";

    public SinhVienHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        path=context.getFilesDir()+"/db/" +DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<SinhVien> loadSV() {
        SQLiteDatabase db;
        ArrayList<SinhVien> lsSinhVien=new ArrayList<>();
        db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        Cursor cursor = db.rawQuery("select * from SinhVien",null);
        if (cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setMaSV(cursor.getInt(0));
                sv.setTenSV(cursor.getString(1));
                lsSinhVien.add(sv);
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lsSinhVien;
    }

    public void insertNewSinhVien(SinhVien sv)
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);

        ContentValues values = new ContentValues();
        values.put(MSINHVIENn_COL,sv.getMaSV());
        values.put(TSINHVIEN_COL,sv.getTenSV());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public  void updateSinhVien(SinhVien oldSinhVien, SinhVien newSinhVien)
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        ContentValues values = new ContentValues();
        values.put(MSINHVIENn_COL,newSinhVien.getMaSV());
        values.put(TSINHVIEN_COL,newSinhVien.getTenSV());
        db.update(TABLE_NAME,values,"maSV=?",
                new String[]{String.valueOf(oldSinhVien.getMaSV())});
        db.close();
    }

    public void deleteSinhVien(SinhVien sinhVien) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        db.delete(TABLE_NAME, "maSV=?", new String[]{String.valueOf(sinhVien.getMaSV())});
        db.close();
    }

}
