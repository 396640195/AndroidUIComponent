package com.component.demo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 */

public class CommonAdapter<T>  extends BaseAdapter {
    protected List<T> data = new ArrayList<>();
    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public  T getItem(int position) {
        return data == null ? null : (position > data.size()-1 ? null : data.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void add(List<T> obj){
        this.data.addAll(obj);
    }

    public void clear(){
        this.data.clear();
    }
}
