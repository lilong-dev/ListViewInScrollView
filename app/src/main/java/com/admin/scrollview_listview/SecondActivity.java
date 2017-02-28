package com.admin.scrollview_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/2/28.
 */

public class SecondActivity extends AppCompatActivity {
    private Button btnBack;
    private ListView mListView;
    private MyScrollView myScrollView;
    List<String> mData = Arrays.asList("A","B","C","D","E","F","G");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        mListView = (ListView) findViewById(R.id.listView);
        myScrollView = (MyScrollView) findViewById(R.id.mScrollView);
        btnBack = (Button) findViewById(R.id.back);
        myScrollView.setListView(mListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item,R.id.item,mData);
        mListView.setAdapter(adapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
