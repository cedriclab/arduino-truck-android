package com.cedriclab.arduinotruck.collections;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;

import com.cedriclab.arduinotruck.ArduinoTruckApplication;
import com.cedriclab.arduinotruck.models.AvailableDevice;

import java.util.ArrayList;

import java.util.logging.LogRecord;

/**
 * Created by cedriclevasseur-laberge on 16-09-24.
 */
public class AvailableDevices extends ArrayList<AvailableDevice> {

    private static final long SCAN_PERIOD = 10000;
    private boolean scanning;
    private Handler handler;

    private BluetoothAdapter.LeScanCallback bleScanCallback;

    public AvailableDevices() {
        super();
        bleScanCallback = new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
                parseDevice(device, rssi, scanRecord);
            }
        };

        handler = new Handler();
    }

    public void loadStored() {
        //TODO : load from SQLite
    }

    public void scan() {
        BluetoothAdapter bleAdapter = ArduinoTruckApplication.getBluetoothAdapter();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scanning = false;
                bleAdapter.stopLeScan(bleScanCallback);
            }
        }, SCAN_PERIOD);

        scanning = true;
        bleAdapter.startLeScan(bleScanCallback);
    }

    public void update() {

    }

    private void parseDevice(BluetoothDevice device, int rssi, byte[] scanRecord) {
        //TODO : upsert info into SQLite and retrieve id
        int id = 0;

        add(new AvailableDevice(id, device, rssi, scanRecord));
    }
}
