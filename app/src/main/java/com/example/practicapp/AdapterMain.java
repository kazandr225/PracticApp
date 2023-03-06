package com.example.practicapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMain extends BaseAdapter{

    private  Context mContext;
    List<MainActivity> mainList;

    public AdapterMain()
    {
        this.mContext = mContext;
        this.mainList = mainList;
    }

    @Override
    public int getCount() {
        return mainList.size();
    }

    @Override
    public Object getItem(int i) {
        return mainList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mainList.get(i).getId();
        //return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        return null;
    }


}
