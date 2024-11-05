package com.xdee.lab1_datnxph36362.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xdee.lab1_datnxph36362.DTO.CatDTO;
import com.xdee.lab1_datnxph36362.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<CatDTO> listCat;

    public CategoryAdapter(Context context, ArrayList<CatDTO> listCat) {

        this.context = context;
        this.listCat = listCat;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int position) {
        return listCat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCat.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView != null) {
            row = convertView;
        } else {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.row_list_cat, null);
        }
        CatDTO objCat = listCat.get(position);
        TextView tv_id = row.findViewById(R.id.tv_id);
        TextView tv_name = row.findViewById(R.id.tv_name);
        Button btn_update = row.findViewById(R.id.btn_update);
        Button btn_delete = row.findViewById(R.id.btn_delete);
        tv_id.setText(objCat.getId() + "");
        tv_name.setText(objCat.getName());
        return row;
    }
}
