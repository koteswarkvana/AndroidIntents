package com.koti.apple.androidintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    public static final String MESSAGE  = "MESSAGE";
    private EditText etrValue;
    private Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: intents using ...");
        etrValue= (EditText) findViewById(R.id.et_value);
        btSubmit= (Button) findViewById(R.id.btsubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: button clicked >>> ");
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra(MESSAGE, etrValue.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
       /* switch (view.getId()){
            case R.id.btsubmit :
                Log.i(TAG, "onClick: button clicked >>> ");
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra(MESSAGE, etrValue.getText().toString());
                break;
        }*/
    }

}
