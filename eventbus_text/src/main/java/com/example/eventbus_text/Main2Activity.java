package com.example.eventbus_text;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

public class Main2Activity extends Activity implements View.OnClickListener {

    private Button btn_first_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        btn_first_event = (Button) findViewById(R.id.btn_first_event);

        btn_first_event.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_event:
                EventBus.getDefault().post(
                        new FirstEvent("FirstEvent btn clicked"));
                break;
        }
    }
}
