package com.cedriclab.arduinotruck.helpers;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cedriclab.arduinotruck.models.AvailableDevice;

import java.util.List;

/**
 * Created by cedriclevasseur-laberge on 16-07-21.
 */
public class DevicesAdapter extends ArrayAdapter<AvailableDevice> {

    public DevicesAdapter(Context context, int resource, List<AvailableDevice> objects) {
        super(context, resource, objects);
    }

}
