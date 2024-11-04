package com.xdee.lab1_datnxph36362.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context){
        super(context,"QLBH.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCat = "CREATE TABLE tb_cat (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXTUNIQUE NOT NULL);";
        db.execSQL(sqlCat);

        String sqlProduct = "CREATE TABLE tb_product (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXTUNIQUE NOT NULL, price REAL DEFAULT (0.0) NOT NULL, id_cat INTEGER REFERENCES tb_cat (id) );";
        db.execSQL(sqlProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL("DROP TABLE IF EXISTS tb_cat");
            db.execSQL("DROP TABLE IF EXISTS tb_product");
            onCreate(db);
        }
    }
}
