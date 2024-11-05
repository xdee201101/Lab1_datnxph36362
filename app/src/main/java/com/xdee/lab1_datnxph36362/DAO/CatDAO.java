package com.xdee.lab1_datnxph36362.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.xdee.lab1_datnxph36362.DBHelper.MyDBHelper;
import com.xdee.lab1_datnxph36362.DTO.CatDTO;

import java.util.ArrayList;

public class CatDAO {
    MyDBHelper dbHelper;
    SQLiteDatabase db;

    public CatDAO(Context context) {
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int AddRow(CatDTO objCat) {
        ContentValues v = new ContentValues();
        v.put("name", objCat.getName());
        int kq = (int) db.insert("tb_cat", null, v);
        return kq;
    }

    public ArrayList<CatDTO> getList() {
        ArrayList<CatDTO> listCat = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT id, name FROM tb_cat", null);
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                CatDTO objCat = new CatDTO(id, name);
                listCat.add(objCat);
            } while (c.moveToNext());
        } else {
            Log.d("xxxxxx", "catDAO::getList: Ko lấy được dữ liệu");
        }
        return listCat;
    }
}
