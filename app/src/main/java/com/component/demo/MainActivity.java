package com.component.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.component.demo.adapter.DemoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    ListView mListView;
    DemoListAdapter adapter;
    List<DemoListAdapter.Entity> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initData();
        this.initViews();
    }

    private void initData(){
        data = new ArrayList<>();
        data.add(new DemoListAdapter.Entity(ColorPhraseActivity.class,"ColorPhrase 改变指定文字的显示颜色"));
        data.add(new DemoListAdapter.Entity(CropActivity.class,"CropActivity 图片剪裁"));
    }

    private void initViews(){
        mListView = (ListView)this.findViewById(R.id.component_list);
        adapter = new DemoListAdapter(this);
        adapter.add(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DemoListAdapter.Entity entity = adapter.getItem(position);
        Intent intent = new Intent();
        intent.setClass(this,entity.clazz);
        startActivity(intent);
    }
}
