package com.xdee.lab1_datnxph36362;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xdee.lab1_datnxph36362.Adapter.CategoryAdapter;
import com.xdee.lab1_datnxph36362.DAO.CatDAO;
import com.xdee.lab1_datnxph36362.DTO.CatDTO;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
    CatDAO catDAO;
    ArrayList<CatDTO> listCat;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lv_cat = findViewById(R.id.lv_cat);
        Button btn_add = findViewById(R.id.btn_add);
        catDAO = new CatDAO(this);
        listCat = catDAO.getList();
        adapter = new CategoryAdapter(this, listCat);
        lv_cat.setAdapter(adapter);
    }
}