package com.example.lenovo.tj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.lenovo.tj.view.MyCircle;

public class MyCircleActivity extends AppCompatActivity {

    private MyCircle myCircle;
    private FrameLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        myCircle = (MyCircle) findViewById(R.id.myCircle);
        activity_main = (FrameLayout) findViewById(R.id.activity_main);

    }
    public void showClickArea(int area) {
        switch (area){
            case 1:
                Toast.makeText(MyCircleActivity.this,"您点击到了第1块区域！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyCircleActivity.this, MyPandaCircleActivity.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(MyCircleActivity.this,"您点击到了第2块区域！",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MyCircleActivity.this,"您点击到了第3块区域！",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
