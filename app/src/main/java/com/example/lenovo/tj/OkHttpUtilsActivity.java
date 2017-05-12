package com.example.lenovo.tj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.tj.uri.Uri;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class OkHttpUtilsActivity extends AppCompatActivity {

    private RecyclerView ok_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_utils);
        initView();
        initData();

    }

    private void initData() {
        OkHttpUtils.get().url(Uri.PATH4).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Call call, String s) {

            }
        });


    }

    private void initView() {
        ok_recycler = (RecyclerView) findViewById(R.id.ok_recycler);
    }
}
