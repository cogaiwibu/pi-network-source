package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.facebook.ads.internal.botdetection.signals.biometric.model.SensorType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.6O  reason: invalid class name */
public final class AnonymousClass6O implements SensorEventListener {
    public static byte[] A09;
    public static String[] A0A;
    public static final String A0B = AnonymousClass6O.class.getSimpleName();
    public AnonymousClass6M A00;
    public final Context A01;
    public final SensorManager A02;
    public final Handler A03;
    public final AnonymousClass6J A04;
    public final AnonymousClass6L A05;
    public final EnumC01856m A06;
    public final List<Sensor> A07;
    public final Map<Integer, AnonymousClass6S> A08 = new HashMap();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0A[3].charAt(12) != 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[7] = "dphTU4VZCJVUxlSWVafH1ZM";
            strArr[1] = "vTUzDZVZybplSM6lZClu7qj";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 84);
            i4++;
        }
    }

    public static void A01() {
        A09 = new byte[]{-3, -17, -8, -3, -7, -4};
    }

    public static void A02() {
        A0A = new String[]{"LMEfueB4gayQvpRN8xXm9AklEevQLqxV", "qKD5N87REqvFR6TOuYJE2bL", "", "yxtXe6d26bGgo70LmfUKAtnwRWe4i0hP", "QGB0NXt3pt8pLttf5OCs6Mo1nTnYeT90", "cpHchmbIsy8OjJq5SMyv1Bjwv0Y4tWtv", "hkg18epqSSQRsZzRGzTmSQr5c5v3YJAV", "CsdF03UMAkfQBN54GO6xo56"};
    }

    static {
        A02();
        A01();
    }

    public AnonymousClass6O(Context context, AnonymousClass6J r5, EnumC01856m r6) {
        this.A01 = context;
        this.A03 = new Handler(AnonymousClass73.A00().A04().getLooper());
        this.A02 = (SensorManager) context.getSystemService(A00(0, 6, 54));
        this.A07 = this.A02.getSensorList(-1);
        this.A04 = r5;
        this.A05 = new AnonymousClass6L(this.A04, r6);
        this.A06 = r6;
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A03(List<AnonymousClass6S> list) {
        try {
            for (AnonymousClass6S r6 : list) {
                if (r6 != null) {
                    int A032 = r6.A03();
                    if (A032 != -1) {
                        if (this.A08.get(Integer.valueOf(r6.ordinal())) == null) {
                            if (A032 != 0) {
                                Iterator<SensorType> it = this.A07.iterator();
                                while (it.hasNext()) {
                                    Sensor sensor = (Sensor) it.next();
                                    if (A032 == sensor.getType()) {
                                        this.A00 = new AnonymousClass6M(this);
                                        this.A02.registerListener(this.A00, sensor, 3, this.A03);
                                        this.A08.put(Integer.valueOf(r6.ordinal()), r6);
                                    }
                                }
                            } else if (AnonymousClass6N.A00[r6.ordinal()] == 1) {
                                this.A05.A03(this.A01);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
        return;
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A04(List<AnonymousClass6S> list) {
        try {
            if (this.A08 != null) {
                if (list == null) {
                    this.A02.unregisterListener(this.A00);
                    this.A05.A02();
                    this.A08.clear();
                    return;
                }
                for (AnonymousClass6S r4 : list) {
                    int A032 = r4.A03();
                    if (A0A[5].charAt(31) != 'v') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0A;
                    strArr[2] = "A8Tij6HFi5g0fGh7y9Y4xTKtDJl0XAe";
                    strArr[2] = "A8Tij6HFi5g0fGh7y9Y4xTKtDJl0XAe";
                    if (A032 != -1) {
                        if (r4.A03() == 0) {
                            this.A08.remove(Integer.valueOf(r4.ordinal()));
                            if (AnonymousClass6N.A00[r4.ordinal()] == 1) {
                                this.A05.A02();
                            }
                        }
                        Iterator<Sensor> it = this.A07.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Sensor next = it.next();
                            if (r4.A03() == next.getType()) {
                                try {
                                    this.A02.unregisterListener(this.A00, next);
                                    this.A08.remove(Integer.valueOf(r4.ordinal()));
                                    break;
                                } catch (Throwable t) {
                                    AnonymousClass6B.A04(t);
                                }
                            }
                        }
                    }
                }
                return;
            }
            return;
        } catch (Throwable t2) {
            AnonymousClass6B.A04(t2);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0084, code lost:
        if (r9 != 18) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        if (r9 != 18) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        r13.A04.A02(new com.facebook.ads.redexgen.X.WT(r1, r4, r14.values[0]), com.facebook.ads.redexgen.X.AnonymousClass6I.A0D);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSensorChanged(android.hardware.SensorEvent r14) {
        /*
        // Method dump skipped, instructions count: 434
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass6O.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
