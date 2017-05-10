package com.example.lenovo.tj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.lenovo.tj.view.MyPandaCircle;

public class MyPandaCircleActivity extends Activity implements View.OnClickListener{

    private MyPandaCircle pandaCircle;
    private RelativeLayout activity_main2;
    private RotateAnimation mAnimation;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        pandaCircle = (MyPandaCircle) findViewById(R.id.pandaCircle);
        activity_main2 = (RelativeLayout) findViewById(R.id.activity_main2);

        mAnimation = new RotateAnimation(0, 36000, Animation.RELATIVE_TO_SELF, 0.5f, Animation
                .RELATIVE_TO_SELF, 0.5f);
        mAnimation.setDuration(200000);
        mAnimation.setInterpolator(new LinearInterpolator());

        pandaCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pandaCircle.startAnimation(mAnimation);
            }
        });

        activity_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimation.cancel();
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(MyPandaCircleActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }




}
