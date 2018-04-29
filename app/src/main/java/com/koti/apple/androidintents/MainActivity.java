package com.koti.apple.androidintents;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    public static final String STR_ARRAYLIST = "STR_ARRAYLIST";
    public static final String STR_ARRAY = "STR_ARRAY";
    public static final String STR_MESSAGE = "STR_MESSAGE";
    public static final String INT_VALUE = "INT_VALUE";
    public static final String FLOAT_VALUE = "FLOAT_VALUE";
    public static final String DOUBLE_VALUE = "DOUBLE_VALUE";
    public static final String LONG_VALUE = "LONG_VALUE";
    public static final String CHAR_VALUE = "CHAR_VALUE";
    public static final String BOOLEAN_VALUE = "BOOLEAN_VALUE";

    private String[] languageNames = {"objective-c", "swift", "android", "kotlin", "ruby", "sql", "javascript"};
    private ArrayList<String> androidTopics = new ArrayList<>();

    private EditText etrValue;
    private Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: intents using ...");
        etrValue = (EditText) findViewById(R.id.et_value);
        btSubmit = (Button) findViewById(R.id.btsubmit);
        btSubmit.setOnClickListener(this);
        // Adding elements to the array list
        androidTopics.add("Activity");
        androidTopics.add("Fragment");
        androidTopics.add("Services");
        androidTopics.add("Content Provider");
        androidTopics.add("Broadcast Receiver");
        androidTopics.add("Sqlite Database");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btsubmit:
                Log.i(TAG, "onClick: button clicked >>> ");
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra(STR_MESSAGE, etrValue.getText().toString());
                intent.putExtra(INT_VALUE, 1234);
                intent.putExtra(FLOAT_VALUE, 123.4);
                intent.putExtra(DOUBLE_VALUE, 12.34);
                intent.putExtra(LONG_VALUE, 12345678);
                intent.putExtra(CHAR_VALUE, 'c');
                intent.putExtra(BOOLEAN_VALUE, true);

                intent.putExtra(STR_ARRAY, languageNames);
                intent.putStringArrayListExtra(STR_ARRAYLIST, androidTopics);
                startActivity(intent);
                break;
        }
    }

}
