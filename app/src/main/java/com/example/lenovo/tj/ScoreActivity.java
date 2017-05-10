package com.example.lenovo.tj;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.lenovo.tj.view.ScoreView;


public class ScoreActivity extends Activity {
    private LinearLayout scoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreView = (LinearLayout) findViewById(R.id.score_View);

        this.scoreView.addView(new ScoreView(this,80));


    }
}
