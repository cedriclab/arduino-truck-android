package com.cedriclab.arduinotruck;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by cedriclevasseur-laberge on 16-07-21.
 */
public class ArduinoTruckApplication extends Application {

    private static ArduinoTruckApplication arduinoTruckApplication;

    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;

    @Override
    public void onCreate() {
        super.onCreate();

        arduinoTruckApplication = this;

        bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
    }

    public static ArduinoTruckApplication getArduinoTruckApplication() {
        return arduinoTruckApplication;
    }

    public BluetoothAdapter getBLEAdapter() {
        return bluetoothAdapter;
    }

    public static BluetoothAdapter getBluetoothAdapter() {
        return getArduinoTruckApplication().getBLEAdapter();
    }

    public static boolean checkBLEAvailability() {
        ArduinoTruckApplication app = getArduinoTruckApplication();
        BluetoothAdapter ba = app.getBLEAdapter();
        return app.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE) && ba != null && ba.isEnabled();
    }

}
