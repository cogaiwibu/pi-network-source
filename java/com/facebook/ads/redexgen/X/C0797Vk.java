package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Vk  reason: case insensitive filesystem */
public final class C0797Vk extends AnonymousClass6Z {
    public static byte[] A07;
    public static final String A08 = C0797Vk.class.getSimpleName();
    public final Context A00;
    @Nullable
    public final PackageInfo A01;
    @Nullable
    public final PackageManager A02;
    public final C01725z A03;
    @Nullable
    public final ActivityInfo[] A04;
    @Nullable
    public final ServiceInfo[] A05;
    @Nullable
    public final String[] A06;

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{29, 57, 35, 35, 57, 62, 55, 112, 0, 49, 51, 59, 49, 55, 53, 112, 0, 53, 34, 61, 57, 35, 35, 57, 63, 62, 35};
    }

    static {
        A07();
    }

    public C0797Vk(Context context, C01725z r3) {
        super(context, r3);
        this.A00 = context;
        this.A03 = r3;
        this.A01 = A02(context);
        this.A02 = context.getPackageManager();
        this.A04 = A08(context);
        this.A05 = A0A(context);
        this.A06 = A0C(context);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private PackageInfo A02(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 39), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ActivityInfo[] A08(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 39), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ServiceInfo[] A0A(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 39), e);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private String[] A0C(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(A08, A06(0, 27, 39), e);
            return null;
        }
    }

    public final AbstractC01816i A0H() {
        return new C0795Vi(this);
    }

    public final AbstractC01816i A0I() {
        return new C0794Vh(this);
    }

    public final AbstractC01816i A0J() {
        return new C0796Vj(this);
    }

    public final AbstractC01816i A0K() {
        return new C0793Vg(this);
    }

    public final AbstractC01816i A0L() {
        return new C0788Vb(this);
    }

    public final AbstractC01816i A0M() {
        return new VX(this);
    }

    public final AbstractC01816i A0N() {
        return new C0789Vc(this);
    }

    public final AbstractC01816i A0O() {
        return new C0792Vf(this);
    }

    public final AbstractC01816i A0P() {
        return new C0790Vd(this);
    }

    public final AbstractC01816i A0Q() {
        return new C0791Ve(this);
    }

    public final AbstractC01816i A0R() {
        return new C0787Va(this);
    }

    public final AbstractC01816i A0S() {
        return new VZ(this);
    }

    public final AbstractC01816i A0T() {
        return new VY(this);
    }

    public final AbstractC01816i A0U() {
        return new VV(this);
    }

    public final AbstractC01816i A0V() {
        return new VU(this);
    }

    public final AbstractC01816i A0W() {
        return new VW(this);
    }

    public final AbstractC01816i A0X() {
        return new VS(this);
    }

    public final AbstractC01816i A0Y() {
        return new VR(this);
    }

    public final AbstractC01816i A0Z() {
        return new VT(this);
    }
}
