package com.example.checkboxrecycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends Activity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        String[] strings = str.split("-");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Main2Activity.this, android
                .R.layout.simple_list_item_1,strings);
        lv.setAdapter(adapter);
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.text_recycler);
    }
}
