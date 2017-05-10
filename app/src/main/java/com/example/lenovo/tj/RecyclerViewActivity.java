package com.example.lenovo.tj;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lenovo.tj.adapter.MyRecyclerAdapter;
import com.example.lenovo.tj.bean.Bean_Recycler;
import com.example.lenovo.tj.uri.Uri;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RecyclerViewActivity extends Activity {

    private RecyclerView recycler;
    private RelativeLayout activity_recycler_view;
    private List<Bean_Recycler.StudentsBean.StudentBean> mStudent = new ArrayList<>();
    private OkHttpClient mOkHttpClient;
    Handler handler  = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String  obj = (String) msg.obj;
            Gson gson = new Gson();
            Bean_Recycler json = gson.fromJson(obj, Bean_Recycler.class);
            mStudent =  json.getStudents().getStudent();
            MyRecyclerAdapter adapter = new MyRecyclerAdapter(RecyclerViewActivity.this, mStudent);
            LinearLayoutManager manager = new LinearLayoutManager(RecyclerViewActivity.this);
            recycler.setAdapter(adapter);
            recycler.setLayoutManager(manager);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initData();


        /*String str = "{ \"Students\": { \"Student\": [ { \"name\": \"张三\", \"content\": " +
                "\"学生简介学生简介学生简介学生简介学生简介\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" }, { \"name\": \"李四\"," +
                " \"content\": \"这是一个好学生，好好学习，特别努力\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" }, { \"name\": \"王五\"," +
                " \"content\": \"喜欢读书，喜欢英语，认真学习的时候特别多\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" }, { \"name\": " +
                "\"赵老大\", \"content\": \"长的好看，个头大\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" }, { \"name\": " +
                "\"秦老二\", \"content\": \"努力学习，认真工作\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" }, { \"name\": " +
                "\"齐老三\", \"content\": \"齐老三学习好，是一个三好学生\", \"img\": \"http://img.juhe" +
                ".cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg\" } ] } }";
        Gson gson = new Gson();
        Bean_Recycler json = gson.fromJson(str, Bean_Recycler.class);
        mStudent =  json.getStudents().getStudent();*/



    }
    //加载数据
    private void initData() {
        File sdcache = getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
        mOkHttpClient = builder.build();
        Request.Builder requestBuilder = new Request.Builder().url(Uri.PATH);
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call call = mOkHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    String string = response.body().string();
                    Message message = new Message();
                    message.obj = string;
                    handler.sendMessage(message);
                    Log.d("xxx", "cache---" + str);
                } else {
                    String string = response.body().string();
                    String str = response.networkResponse().toString();
                    Log.d("xxx", "network---" + string);
                    Log.d("xxx", "network---0000000000000" + str);
                    Message message = new Message();
                    message.obj = string;
                    handler.sendMessage(message);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initData2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                OkHttpClient build = builder.build();
                Request get = new Request.Builder().url(Uri.PATH).method("GET", null).build();
                Call call = build.newCall(get);
                try {
                    Response execute = call.execute();
                    if (execute.isSuccessful()){
                        String s = execute.body().string();
                        Message message = new Message();
                        message.obj = s;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initData3(){
        RequestBody formBody = new FormBody.Builder()
                .add("page", "1")
                .add("code", "news")
                .add("pageSize", "20")
                .add("parentid", "0")
                .add("type", "1")
                .build();
        OkHttpClient build1 = new OkHttpClient.Builder().build();
        Request build = new Request.Builder().method("POST",formBody).url(Uri.PATH3).build();
        Call call = build1.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    String string = response.body().string();
                    /*Message message = new Message();
                    message.obj = string;
                    handler.sendMessage(message);*/
                    Log.d("xxx", "cache---" + str);
                } else {
                    String string = response.body().string();
                    String str = response.networkResponse().toString();
                    Log.d("xxx", "network---" + string);
                    Log.d("xxx", "network---0000000000000" + str);
                    /*Message message = new Message();
                    message.obj = string;
                    handler.sendMessage(message);*/
                }
            }
        });
    }

    private void initData4(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody formBody = new FormBody.Builder()
                        .add("page", "1")
                        .add("code", "news")
                        .add("pageSize", "20")
                        .add("parentid", "0")
                        .add("type", "1")
                        .build();
                OkHttpClient build1 = new OkHttpClient.Builder().build();
                Request build = new Request.Builder().method("POST",formBody).url(Uri.PATH3).build();
                Call call = build1.newCall(build);
                try {
                    Response execute = call.execute();
                    if (execute.isSuccessful()){
                        String string = execute.body().string();
                        Log.d("xxx", "cache---" + string);
                    }else {
                        Log.d("xxx", "cache---失败了");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }



    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.re);
        activity_recycler_view = (RelativeLayout) findViewById(R.id.activity_recycler_view);
    }
}
