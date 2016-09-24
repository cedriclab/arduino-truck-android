package com.cedriclab.arduinotruck.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cedriclab.arduinotruck.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void triggerDeviceSelector(View view) {
        Intent intent = new Intent(this, DeviceScanner.class);
        startActivity(intent);
    }



}
