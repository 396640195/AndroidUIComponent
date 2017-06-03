package com.component.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.component.demo.adapter.DemoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView mListView;
    List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initData();
        this.initViews();
    }

    private void initData(){
        data = new ArrayList<>();
        data.add("ColorPhrase 改变指定文字的显示颜色");
    }

    private void initViews(){
        mListView = (ListView)this.findViewById(R.id.component_list);
        DemoListAdapter adapter = new DemoListAdapter(this);
        adapter.add(data);
        mListView.setAdapter(adapter);
    }
}
