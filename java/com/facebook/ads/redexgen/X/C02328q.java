package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.ads.redexgen.X.8q  reason: invalid class name and case insensitive filesystem */
public class C02328q implements SensorEventListener {
    public C02328q() {
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] unused = C02338r.A0A = sensorEvent.values;
        C02338r.A07();
    }
}
