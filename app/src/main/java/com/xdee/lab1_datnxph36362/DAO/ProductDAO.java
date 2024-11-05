package com.xdee.lab1_datnxph36362.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.xdee.lab1_datnxph36362.DBHelper.MyDBHelper;
import com.xdee.lab1_datnxph36362.DTO.CatDTO;
import com.xdee.lab1_datnxph36362.DTO.ProductDTO;

import java.util.ArrayList;

public class ProductDAO {
    MyDBHelper dbHelper;
    SQLiteDatabase db;

    public ProductDAO(Context context) {
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int AddRow(ProductDTO objProduct) {
        ContentValues v = new ContentValues();
        v.put("name", objProduct.getName());
        v.put("price", objProduct.getPrice());
        v.put("id_cat", objProduct.getId_cat());
        int kq = (int) db.insert("tb_product", null, v);
        return kq;
    }

    public ArrayList<ProductDTO> getList() {
        ArrayList<ProductDTO> listProduct = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT id, name, price, id_cat", null);
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                int price = c.getInt(2);
                int id_cat = c.getInt(3);
                ProductDTO objProduct = new ProductDTO(id, name, price, id_cat);
                listProduct.add(objProduct);
            } while (c.moveToNext());
        } else {
            Log.d("xxxxxx", "ProductDTO::getList: Ko lấy được dữ liệu");
        }
        return listProduct;
    }
}
