package com.koti.apple.androidintents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        String msg = getIntent().getExtras().getString(MainActivity.MESSAGE, "");
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_msg.setText(msg);
    }
}
