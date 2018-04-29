package com.koti.apple.androidintents;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

// https://stackoverflow.com/questions/8701634/send-email-intent
public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SecondActivity";
    private TextView tv_msg;
    private EditText et_message_information;
    private Button bt_send_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        et_message_information = (EditText) findViewById(R.id.et_message_information);
        bt_send_email = (Button) findViewById(R.id.bt_send_email);
        bt_send_email.setOnClickListener(this);
        String strMsg = getIntent().getExtras().getString(MainActivity.STR_MESSAGE, "");
        int intVal = getIntent().getExtras().getInt(MainActivity.INT_VALUE, 0);
        // TODO:- unable to accessing the float and long value
        long longVal = getIntent().getExtras().getLong(MainActivity.LONG_VALUE, 0);
        float floatVal = getIntent().getExtras().getFloat(MainActivity.FLOAT_VALUE, 0);

        double doubleVal = getIntent().getExtras().getDouble(MainActivity.DOUBLE_VALUE, 0);
        char charVal = getIntent().getExtras().getChar(MainActivity.CHAR_VALUE);
        boolean booleanVal = getIntent().getExtras().getBoolean(MainActivity.BOOLEAN_VALUE);

        String[] languageNamesArr1 = getIntent().getExtras().getStringArray(MainActivity.STR_ARRAY);

        ArrayList<String> topicNames = getIntent().getStringArrayListExtra(MainActivity.STR_ARRAYLIST);
        Log.e(TAG, "onCreate: msg >> " + strMsg);
        Log.e(TAG, "onCreate: intVal >> " + intVal);
        Log.e(TAG, "onCreate: floatVal >> " + floatVal);
        Log.e(TAG, "onCreate: doubleVal >> " + doubleVal);
        Log.e(TAG, "onCreate: longVal >> " + longVal);
        Log.e(TAG, "onCreate: charVal >> "+ charVal);
        Log.e(TAG, "onCreate: booleanVal >> " + booleanVal);
        // Display the language array names
        for (String languageName : languageNamesArr1) {
            Log.e(TAG, "onCreate: languageName >> " + languageName.toUpperCase());
        }
        // Display the topic list of names
        for (String topicName : topicNames) {
            Log.e(TAG, "onCreate: topicName >> " + topicName.toUpperCase());
        }
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_msg.setText(strMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_send_email:
                Log.e(TAG, "onClick: sending email >> ");
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","koteswaraod9@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi:");
                emailIntent.putExtra(Intent.EXTRA_TEXT, et_message_information.getText().toString());
                // Displaying chooser email apps along with title "Send email..."
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                break;
        }
    }
}
