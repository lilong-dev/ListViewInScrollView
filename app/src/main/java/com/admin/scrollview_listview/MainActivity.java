package com.admin.scrollview_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyListView mListView;
    List<String> mData = Arrays.asList("A","B","C","D","E","F","G");
    Button btnSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (MyListView) findViewById(R.id.listView);
        btnSecond = (Button) findViewById(R.id.btn_enter_second);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item,R.id.item,mData);
        mListView.setAdapter(adapter);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
