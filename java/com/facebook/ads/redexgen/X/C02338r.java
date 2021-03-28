package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.8r  reason: invalid class name and case insensitive filesystem */
public final class C02338r {
    public static Sensor A00 = null;
    public static Sensor A01 = null;
    public static SensorEventListener A02;
    public static SensorEventListener A03;
    public static SensorManager A04 = null;
    public static Map<String, String> A05 = new ConcurrentHashMap();
    public static byte[] A06;
    public static String[] A07 = {A01(152, 1, 74), A01(153, 1, 74), A01(154, 1, 7)};
    public static final AtomicReference<String> A08 = new AtomicReference<>();
    public static volatile float[] A09;
    public static volatile float[] A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-97, -12, -16, -14, -14, -12, -5, -12, 1, -2, -4, -12, 3, -12, 1, -18, -67, -65, -48, -59, -46, -59, -48, -43, 41, 54, 44, 58, 55, 49, 44, -10, 49, 54, 60, 45, 54, 60, -10, 41, 43, 60, 49, 55, 54, -10, 10, 9, 28, 28, 13, 26, 33, 39, 11, 16, 9, 22, 15, 13, 12, 23, 44, 23, 31, 34, 23, 24, 34, 27, 21, 35, 27, 35, 37, 40, 47, 33, 32, 51, 51, 36, 49, 56, -4, 1, -6, 11, 0, 2, 7, 0, 35, 47, 34, 34, 28, 48, 45, 30, 32, 34, -18, -20, -11, -20, -7, -16, -22, 19, 12, 29, 12, 19, -60, -63, -58, -77, -58, -69, -63, -64, -79, -60, -76, -78, -67, -74, 4, -10, -1, 4, 0, 3, 8, 9, -10, 9, 10, 8, 45, 40, 45, 26, 37, 24, 38, 30, 38, 40, 43, 50, 16, 17, -49};
    }

    /* JADX WARNING: Error to parse debug info: 6 in method: com.facebook.ads.redexgen.X.8r.A08(android.content.Context):void, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static void A08(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String valueOf = String.valueOf(((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        A08.set(valueOf);
        A05.put(A01(92, 10, 111), valueOf);
    }

    static {
        A03();
    }

    @Nullable
    public static String A00() {
        return A08.get();
    }

    public static Map<String, String> A02() {
        Map<String, String> currentAnalogInfo = new HashMap<>();
        currentAnalogInfo.putAll(A05);
        A0C(currentAnalogInfo);
        return currentAnalogInfo;
    }

    public static synchronized void A06() {
        synchronized (C02338r.class) {
            if (A04 != null) {
                A04.unregisterListener(A02);
            }
            A02 = null;
        }
    }

    public static synchronized void A07() {
        synchronized (C02338r.class) {
            if (A04 != null) {
                A04.unregisterListener(A03);
            }
            A03 = null;
        }
    }

    public static void A09(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(A01(16, 8, 14))).getMemoryInfo(memoryInfo);
        A05.put(A01(61, 16, 104), String.valueOf(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            A05.put(A01(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 12, 107), String.valueOf(memoryInfo.totalMem));
        }
    }

    public static void A0A(AnonymousClass8H r6) {
        boolean z;
        String A012;
        try {
            Intent batteryIntent = r6.registerReceiver(null, new IntentFilter(A01(24, 37, 122)));
            if (batteryIntent != null) {
                int status = batteryIntent.getIntExtra(A01(109, 5, 89), -1);
                int level = batteryIntent.getIntExtra(A01(123, 5, 3), -1);
                int intExtra = batteryIntent.getIntExtra(A01(134, 6, 71), -1);
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                } else {
                    z = false;
                }
                float f = 0.0f;
                if (level > 0) {
                    f = (((float) status) / ((float) level)) * 100.0f;
                }
                A05.put(A01(77, 7, 113), String.valueOf(f));
                Map<String, String> map = A05;
                if (z) {
                    A012 = A01(1, 1, 117);
                } else {
                    A012 = A01(0, 1, 33);
                }
                map.put(A01(84, 8, 75), A012);
            }
        } catch (IllegalArgumentException e) {
            r6.A04().A82(A01(102, 7, 57), C02248i.A1B, new C02258j(e));
        }
    }

    public static synchronized void A0B(AnonymousClass8H r6) {
        synchronized (C02338r.class) {
            A09(r6);
            A0A(r6);
            if (A04 == null) {
                A04 = (SensorManager) r6.getSystemService(A01(128, 6, 67));
                if (A04 == null) {
                    return;
                }
            }
            if (A00 == null) {
                A00 = A04.getDefaultSensor(1);
            }
            if (A01 == null) {
                A01 = A04.getDefaultSensor(4);
            }
            if (A02 == null) {
                A02 = new C02318p();
                if (A00 != null) {
                    A04.registerListener(A02, A00, 3);
                }
            }
            if (A03 == null) {
                A03 = new C02328q();
                if (A01 != null) {
                    A04.registerListener(A03, A01, 3);
                }
            }
        }
    }

    public static void A0C(Map<String, String> map) {
        float[] currentGyroscopeValues = A09;
        float[] fArr = A0A;
        if (currentGyroscopeValues != null) {
            int min = Math.min(A07.length, currentGyroscopeValues.length);
            for (int i = 0; i < min; i++) {
                map.put(A01(2, 14, 65) + A07[i], String.valueOf(currentGyroscopeValues[i]));
            }
        }
        if (fArr != null) {
            int min2 = Math.min(A07.length, fArr.length);
            for (int i2 = 0; i2 < min2; i2++) {
                map.put(A01(114, 9, 4) + A07[i2], String.valueOf(fArr[i2]));
            }
        }
    }
}
