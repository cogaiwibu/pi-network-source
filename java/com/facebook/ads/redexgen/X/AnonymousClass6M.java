package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.ads.redexgen.X.6M  reason: invalid class name */
public final class AnonymousClass6M implements SensorEventListener {
    public final SensorEventListener A00;

    public AnonymousClass6M(SensorEventListener sensorEventListener) {
        this.A00 = sensorEventListener;
    }

    @SuppressLint({"CatchGeneralException"})
    public final void onAccuracyChanged(Sensor sensor, int i) {
        try {
            this.A00.onAccuracyChanged(sensor, i);
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            this.A00.onSensorChanged(sensorEvent);
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }
}
