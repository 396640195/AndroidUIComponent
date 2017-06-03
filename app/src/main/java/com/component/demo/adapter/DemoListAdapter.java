package com.component.demo.adapter;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/3.
 */

public class DemoListAdapter extends CommonAdapter<String> {
    private Activity mContext;

    public DemoListAdapter(Activity mContext) {
        this.mContext = mContext;
        datas = new ArrayList<String>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        String item = getItem(position);
        if(convertView == null){
            textView = new TextView(mContext);
            convertView = textView;
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.height = 100;
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.LEFT|Gravity.CENTER_HORIZONTAL);
        }else{
            textView = (TextView)convertView;
        }
        textView.setText(item);
        return convertView;
    }


}
