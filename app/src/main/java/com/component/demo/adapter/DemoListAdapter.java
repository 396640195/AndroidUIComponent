package com.component.demo.adapter;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.utils.ScreenUtils;

/**
 * Created by Administrator on 2017/6/3.
 */

public class DemoListAdapter extends CommonAdapter<DemoListAdapter.Entity> {
    private Activity mContext;

    public DemoListAdapter(Activity mContext) {
        this.mContext = mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        DemoListAdapter.Entity item = getItem(position);
        if(convertView == null){
            textView = new TextView(mContext);
            convertView = textView;
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.height = ScreenUtils.dpToPxInt(this.mContext,40);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        }else{
            textView = (TextView)convertView;
        }
        textView.setText(item.title);
        return convertView;
    }


    public static class Entity{
        public Class clazz;
        public String title;

        public Entity(Class clazz, String title) {
            this.clazz = clazz;
            this.title = title;
        }
    }
}
