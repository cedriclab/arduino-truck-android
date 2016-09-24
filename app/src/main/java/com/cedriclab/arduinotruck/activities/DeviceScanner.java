package com.cedriclab.arduinotruck.activities;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cedriclab.arduinotruck.R;
import com.cedriclab.arduinotruck.collections.AvailableDevices;
import com.cedriclab.arduinotruck.helpers.DevicesAdapter;

public class DeviceScanner extends AppCompatActivity {

    private AvailableDevices availableDevices;
    private DevicesAdapter devicesAdapter;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_scanner);

        availableDevices = new AvailableDevices();
        devicesAdapter = new DevicesAdapter(this, R.layout.device, availableDevices);
        listView = (ListView) findViewById(R.id.list_devices);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container_devices);
    }
}
