package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Kq  reason: case insensitive filesystem */
public final class C0523Kq {
    public static byte[] A00;
    public static String[] A01;
    public static final Package A02 = C0523Kq.class.getPackage();
    public static final String A03 = (A02 + A06(0, 19, 81));
    public static final String A04 = (A02 + A06(40, 22, 38));
    public static final String A05 = (A02 + A06(19, 21, 124));
    public static final Set<C0820Wh> A06 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicReference<AbstractC0526Ku> A07 = new AtomicReference<>();

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 18);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-111, -92, -89, -79, -70, -62, -92, -89, -62, -78, -91, -83, -62, -84, -89, -62, -82, -88, -68, -68, -49, -46, -36, -27, -19, -35, -32, -41, -43, -41, -36, -49, -38, -19, -45, -26, -30, -32, -49, -31, 102, 121, 124, -122, -113, -105, -117, 121, -114, 125, 124, -105, -117, -116, 121, -116, 125, -105, 124, 121, -116, 121, -57, -43, -22, -39, -40, -108, -25, -24, -43, -24, -39, -108, -42, -23, -30, -40, -32, -39, -108, -35, -25, -108, -39, -31, -28, -24, -19, -107};
    }

    public static void A08() {
        A01 = new String[]{"R2O7PMYP6nkOeNui3I4WlXx4fu7rpRKA", Const.Y, "n9RLgUbY6qPVyxnn4C2MCNq6tOX6tKMu", "KtI8XvYnNiAs4lVQz", "VIjGruAAxxfbDEfj8", "jnPluIPOifq7BY1vqnqKLiUetY3DHsfM", "J5aiTqmsNT2689NKU", "zCaDldCe0EtEl2h3W"};
    }

    static {
        A08();
        A07();
    }

    public static Intent A00(Intent cloneIntent) {
        Intent cloneFilter = cloneIntent.cloneFilter();
        cloneFilter.setFlags(cloneIntent.getFlags());
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(cloneIntent.getExtras());
        cloneFilter.putExtra(A05, obtain.marshall());
        obtain.recycle();
        return cloneFilter;
    }

    public static Intent A01(Intent startIntent, ClassLoader classLoader) {
        Intent cloneFilter = startIntent.cloneFilter();
        cloneFilter.setFlags(startIntent.getFlags());
        Bundle bundle = new Bundle();
        Parcel obtain = Parcel.obtain();
        byte[] byteArrayExtra = startIntent.getByteArrayExtra(A05);
        if (byteArrayExtra != null) {
            obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            obtain.setDataPosition(0);
            bundle = obtain.readBundle(classLoader);
            obtain.recycle();
        }
        cloneFilter.putExtras(bundle);
        return cloneFilter;
    }

    public static Bundle A02(Bundle bundle, ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A04);
        if (byteArray != null) {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            Bundle readBundle = obtain.readBundle(classLoader);
            obtain.recycle();
            String[] strArr = A01;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "08vXapB5qdF8q1e2g";
            strArr2[3] = "bPV7EQI3jYdBWJzP2";
            return readBundle;
        }
        throw new IllegalStateException(A06(62, 28, 98));
    }

    /* JADX INFO: Multiple debug info for r3v1 java.lang.String: [D('adId' java.lang.String), D('adContext' com.facebook.ads.redexgen.X.Wh)] */
    @Nullable
    public static C0820Wh A03(Intent intent) {
        String adId = intent.getStringExtra(A03);
        if (adId == null) {
            return null;
        }
        for (C0820Wh wh : A06) {
            if (adId.equals(wh.A0A().getId())) {
                return wh;
            }
        }
        return null;
    }

    public static AdActivityIntent A04(C0820Wh wh) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(wh.getApplicationContext(), A05());
        adActivityIntent.putExtra(A03, wh.A0A().getId());
        A06.add(wh);
        return adActivityIntent;
    }

    public static Class A05() {
        if (A01[1].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "4NnM5dRGBMW0KGxzs";
        strArr[3] = "N6FCbEqQMIqNBYuck";
        return AudienceNetworkActivity.class;
    }

    public static void A09(Bundle bundle, Bundle bundle2) {
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle2);
        bundle.putByteArray(A04, obtain.marshall());
        obtain.recycle();
    }

    public static void A0A(C0820Wh wh, AdActivityIntent adActivityIntent) {
        wh.getApplicationContext().startActivity(A00(adActivityIntent));
    }

    public static boolean A0B(Intent intent, Set<String> set) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String prefix = data.toString();
        for (String url : set) {
            if (prefix.startsWith(url)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0C(C0820Wh wh, Intent intent) {
        return A0D(wh, intent, A07.get());
    }

    @VisibleForTesting
    public static boolean A0D(C0820Wh wh, Intent intent, @Nullable AbstractC0526Ku ku) {
        if (A0B(intent, J8.A0U(wh))) {
            return false;
        }
        Activity activity = wh;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "W";
        strArr2[1] = "W";
        Activity A09 = wh.A09();
        if (A09 != null) {
            activity = A09;
        } else {
            intent.addFlags(268435456);
        }
        if (ku != null && !A0B(intent, J8.A0W(wh))) {
            return ku.startActivity(activity, intent);
        }
        activity.startActivity(intent);
        return true;
    }
}
