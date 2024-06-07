package com.example.lab9_letanhung_2001210520.bai1_lab9.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lab9_letanhung_2001210520.bai1_lab9.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "products";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "products";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_QUANTITY = "quantity";

    public ProductHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_products_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY,%s TEXT,%s INTEGER)",
                TABLE_NAME, KEY_ID, KEY_NAME, KEY_QUANTITY);
        db.execSQL(create_products_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_QUANTITY, product.getQuantity());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Product getProduct(int productId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + "=?",
                new String[]{String.valueOf(productId)}, null, null, null);
        Product product = null;
        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int nameIndex = cursor.getColumnIndex(KEY_NAME);
            int quantityIndex = cursor.getColumnIndex(KEY_QUANTITY);

            if (idIndex != -1 && nameIndex != -1 && quantityIndex != -1) {
                product = new Product(cursor.getInt(idIndex),
                        cursor.getString(nameIndex),
                        cursor.getInt(quantityIndex));
            }
            cursor.close();
        }
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int nameIndex = cursor.getColumnIndex(KEY_NAME);
            int quantityIndex = cursor.getColumnIndex(KEY_QUANTITY);

            do {
                if (idIndex != -1 && nameIndex != -1 && quantityIndex != -1) {
                    Product product = new Product(cursor.getInt(idIndex),
                            cursor.getString(nameIndex),
                            cursor.getInt(quantityIndex));
                    productList.add(product);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productList;
    }


    public void updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_QUANTITY, product.getQuantity());
        db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(product.getId())});
        db.close();
    }

    public void deleteProduct(int productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(productId)});
        db.close();
    }


    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs,
                        String groupBy, String having, String orderBy) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql, selectionArgs);
    }
}
