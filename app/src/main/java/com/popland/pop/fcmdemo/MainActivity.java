package com.popland.pop.fcmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity{
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        //get data when app is in background and foreground
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.i("MMMM key-value", key + " : " + value);
                if (key.equals("number"))
                    tv.setText(value.toString());
            }
        }

    }


}
