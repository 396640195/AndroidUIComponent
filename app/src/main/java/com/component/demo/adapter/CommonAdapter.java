package com.component.demo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 */

public class CommonAdapter<T>  extends BaseAdapter {
    protected List<T> datas;
    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public  T getItem(int position) {
        return datas == null ? null : (position > datas.size()-1 ? null : datas.get(position));
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
        this.datas.addAll(obj);
    }
}
