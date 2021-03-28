package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.ads.internal.androidx.support.v4.content.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.2F  reason: invalid class name */
public final class AnonymousClass2F {
    public static AnonymousClass2F A05;
    public static byte[] A06;
    public static String[] A07;
    public static final Object A08 = new Object();
    public final Context A00;
    public final Handler A01;
    public final ArrayList<AnonymousClass2D> A02 = new ArrayList<>();
    public final HashMap<String, ArrayList<AnonymousClass2E>> A03 = new HashMap<>();
    public final HashMap<BroadcastReceiver, ArrayList<AnonymousClass2E>> A04 = new HashMap<>();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 80);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-116, -116, -78, -43, -40, -32, -47, -34, -116, -48, -43, -48, -116, -38, -37, -32, -116, -39, -51, -32, -49, -44, -90, -116, -111, -111, -73, -38, -35, -27, -42, -29, -111, -34, -46, -27, -44, -39, -42, -43, -110, -111, -111, -34, -46, -27, -44, -39, -82, -95, -23, -102, -23, -32, -102, -29, -24, -18, -33, -24, -18, -102, 126, -47, -63, -58, -61, -53, -61, 126, -88, -54, -37, -48, -42, -43, -121, -45, -48, -38, -37, -95, -121, 27, 62, 50, 48, 59, 17, 65, 62, 48, 51, 50, 48, 66, 67, 28, 48, 61, 48, 54, 52, 65, -51, -31, -12, -29, -24, -23, -18, -25, -96, -31, -25, -31, -23, -18, -13, -12, -96, -26, -23, -20, -12, -27, -14, -96, -80, -61, -47, -51, -54, -44, -57, -52, -59, 126, -46, -41, -50, -61, 126, -19, -17, 0, -11, -5, -6, -3, -5, 14, -1, 1, 9, 12, 19, 9, 6, 25, 6, 29, 34, 25, 14, -53, -60, -63, -60, -59, -51, -60, 118, -56, -69, -73, -55, -59, -60};
    }

    public static void A04() {
        A07 = new String[]{"JAgQ2spdQpH8xKgxtQcQLLz6sgGCkpe2", "SMfU9IuS4ycu6Y2ZHRBSqn3aWPXKMTOT", "55l84Ag1V6wgeVOPN73gijnv7nIwTIEx", "eOq258YlCb1TEbA", "VJMc46I8NXWnx7x8GW3WGk3ASQlYYFHT", "LoC5Exa7K60en74lmCNTJxDot4v0o8bM", "KRpLxkqJYlgWqGJZ48eoA1wpDd5KWG89", "Gt8Vn0C4eF81I9TsnyjdaH21jMiVX3Ky"};
    }

    static {
        A04();
        A03();
    }

    public AnonymousClass2F(Context context) {
        this.A00 = context;
        this.A01 = new AnonymousClass2C(this, context.getMainLooper());
    }

    public static AnonymousClass2F A00(Context context) {
        AnonymousClass2F r0;
        synchronized (A08) {
            if (A05 == null) {
                A05 = new AnonymousClass2F(context.getApplicationContext());
            }
            r0 = A05;
        }
        return r0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6 >= r7.length) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r5 = r7[r6];
        r4 = r5.A01.size();
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r3 >= r4) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r1 = r5.A01.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r1.A01 != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r1.A02.onReceive(r8.A00, r5.A00);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r6 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A02() {
        /*
            r8 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.facebook.ads.redexgen.X.2E>> r1 = r8.A04
            monitor-enter(r1)
            java.util.ArrayList<com.facebook.ads.redexgen.X.2D> r0 = r8.A02     // Catch:{ all -> 0x0045 }
            int r0 = r0.size()     // Catch:{ all -> 0x0045 }
            if (r0 > 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0044
        L_0x000d:
            com.facebook.ads.redexgen.X.2D[] r7 = new com.facebook.ads.redexgen.X.AnonymousClass2D[r0]     // Catch:{ all -> 0x0045 }
            java.util.ArrayList<com.facebook.ads.redexgen.X.2D> r0 = r8.A02     // Catch:{ all -> 0x0045 }
            r0.toArray(r7)     // Catch:{ all -> 0x0045 }
            java.util.ArrayList<com.facebook.ads.redexgen.X.2D> r0 = r8.A02     // Catch:{ all -> 0x0045 }
            r0.clear()     // Catch:{ all -> 0x0045 }
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            r6 = 0
        L_0x001b:
            int r0 = r7.length
            if (r6 >= r0) goto L_0x0000
            r5 = r7[r6]
            java.util.ArrayList<com.facebook.ads.redexgen.X.2E> r0 = r5.A01
            int r4 = r0.size()
            r3 = 0
        L_0x0027:
            if (r3 >= r4) goto L_0x0041
            java.util.ArrayList<com.facebook.ads.redexgen.X.2E> r0 = r5.A01
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.2E r1 = (com.facebook.ads.redexgen.X.AnonymousClass2E) r1
            boolean r0 = r1.A01
            if (r0 != 0) goto L_0x003e
            android.content.BroadcastReceiver r2 = r1.A02
            android.content.Context r1 = r8.A00
            android.content.Intent r0 = r5.A00
            r2.onReceive(r1, r0)
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0041:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0044:
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass2F.A02():void");
    }

    public final void A06(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<AnonymousClass2E> remove = this.A04.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    AnonymousClass2E r6 = remove.get(size);
                    r6.A01 = true;
                    for (int i = 0; i < r6.A03.countActions(); i++) {
                        String action = r6.A03.getAction(i);
                        ArrayList<AnonymousClass2E> arrayList = this.A03.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                AnonymousClass2E r1 = arrayList.get(size2);
                                if (r1.A02 == broadcastReceiver) {
                                    r1.A01 = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.A03.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void A07(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            LocalBroadcastManager.ReceiverRecord r5 = new AnonymousClass2E(intentFilter, broadcastReceiver);
            ArrayList<AnonymousClass2E> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(r5);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<LocalBroadcastManager.ReceiverRecord> entries = this.A03.get(action);
                if (entries == null) {
                    entries = new ArrayList<>(1);
                    this.A03.put(action, entries);
                }
                entries.add(r5);
            }
        }
    }

    /* JADX INFO: Multiple debug info for r9v0 java.lang.String: [D('scheme' java.lang.String), D('i' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014b, code lost:
        if (r10 != -2) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015d, code lost:
        if (r10 != -2) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016a, code lost:
        r11 = A01(157, 4, 85);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A08(android.content.Intent r23) {
        /*
        // Method dump skipped, instructions count: 493
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass2F.A08(android.content.Intent):boolean");
    }
}
