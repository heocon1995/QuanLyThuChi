package com.heocon.company.quanlythuchi.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heocon.company.quanlythuchi.R;


public class AdapterNavigation extends ArrayAdapter<String> {
    private Activity a;
    private int id;
    private String[] arr;
    private TextView name;
    private ImageView imageView;

    public AdapterNavigation(Activity context, int resource, String[] objects) {
        super(context, resource, objects);
        this.a = context;
        this.id = resource;
        this.arr = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater in = a.getLayoutInflater();
        view = in.inflate(id, null);
        imageView = (ImageView) view.findViewById(R.id.imgNavigationImage);
        if (arr.length > 0 && position >= 0) {
            name = (TextView) view.findViewById(R.id.txtNavigationName);
            name.setText(arr[position]);
        }
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.ic_add);
                break;
            case 1:
                imageView.setImageResource(R.drawable.ic_show);
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_expenditure);
                break;
            case 3:
                imageView.setImageResource(R.drawable.ic_statistical);
                break;
            case 4:
                imageView.setImageResource(R.drawable.ic_setting);
                break;
            case 5:
                imageView.setImageResource(R.drawable.ic_logout);
                break;
            case 6:
                imageView.setImageResource(R.drawable.ic_exit);
                break;

        }
        return view;
    }
}
