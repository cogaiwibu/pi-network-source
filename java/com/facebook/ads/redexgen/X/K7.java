package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

public class K7 implements LO<Bundle> {
    public static byte[] A0C;
    public static String[] A0D;
    public int A00;
    public int A01;
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public boolean A04;
    public final S6 A05;
    public final C0820Wh A06;
    public final JE A07;
    public final AbstractC0620Om A08;
    public final C0625Or A09;
    public final String A0A;
    @Nullable
    public final Map<String, String> A0B;

    static {
        A0P();
        A0O();
    }

    public static String A0G(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 48);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0C = new byte[]{11, 13, 30, 19, 25, 24, -82, -79, -98, -62, -82, -71, -74, -63, -58, -102, -82, -69, -82, -76, -78, -65, -18, 1, -10, -6, -14, -20, -6, 0, -96, -77, -86, -85, -89, -100, -76, -96, -83, -56, -67, -49, -48, -98, -53, -47, -54, -64, -67, -50, -43, -80, -59, -55, -63, -87, -81, -98, -109, -91, -90, -126, -92, -95, -103, -92, -105, -91, -91, -122, -101, -97, -105, ByteCompanionObject.MAX_VALUE, -123, -21, -31, -33, -14, -35, -21, -15, -23, -33, -14, -16, -37, -23, -17, 20, 12, -33, -37, -45, -43, -56, -45, 26, 30, 13, 17, 6, 10, 2, 27, 34, -87, -98, -94, -102, 37, 27, 16, -16, -26, -25, 19, 9, 10, -2, 21, -64, -70, -78, 10, 4, 11, 5, 3, -8, -4, -12, -18, -4, 2, -64, -63, -87, -82, 0, 1, -23, -4, -3, -8, -9, -8, -30, 5, 6, -4, -74, -73, -83, -95, -72, -21, -35, -30, -40, -29, -21};
    }

    public static void A0P() {
        A0D = new String[]{"nkjKj1MvUJoP2SJPYcgbaBjYPy4EsWOF", "UEaFlSlVJfgDxU2HAGuUlGjRHCZL3UC5", "HKOtxcgqDUvcB7Zt0rEFxuoEqCvYEtNO", "rowCAjgGiKT2zEBSq3xmGSL0Kf3UrlyG", "EJAz0i2eNdRPLBpGYGjYpv17GQTuD6uU", "hVbT72qq2pp8XHiEw", "RwROuq5e2nKVw7hJaeybV0hHAIDx5UQQ", "neuOh54FNoDLqHEFUxNtW4G7fWRiy4GW"};
    }

    public K7(C0820Wh wh, JE je, AbstractC0620Om om, List<AnonymousClass20> list, String str, boolean z) {
        this(wh, je, om, list, str, z, null);
    }

    public K7(C0820Wh wh, JE je, AbstractC0620Om om, List<AnonymousClass20> list, String str, boolean z, @Nullable Bundle bundle) {
        this(wh, je, om, list, str, z, bundle, null);
    }

    public K7(C0820Wh wh, JE je, AbstractC0620Om om, List<AnonymousClass20> list, String str, boolean z, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
        this.A03 = null;
        this.A06 = wh;
        this.A07 = je;
        this.A08 = om;
        this.A0A = str;
        this.A0B = map;
        this.A04 = z;
        list.add(new K9(this, 0.5d, -1.0d, 2.0d, true));
        list.add(new K8(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A05 = new S6(om.getView(), list, bundle.getBundle(A0G(6, 16, 29)), wh);
            this.A01 = bundle.getInt(A0G(57, 18, 2));
            this.A00 = bundle.getInt(A0G(39, 18, 44));
        } else {
            this.A05 = new S6(om.getView(), list, wh);
        }
        this.A09 = new C0625Or(new Handler(), this);
    }

    private final float A0E() {
        return C0531La.A00(this.A06) * this.A08.getVolume();
    }

    private Map<String, String> A0I(int i) {
        boolean z;
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.A08.getVideoStartReason() == EnumC0626Os.A03) {
            z = true;
        } else {
            z = false;
        }
        C0531La.A04(hashMap, z, !this.A08.A7d());
        A0S(hashMap);
        A0R(hashMap);
        A0U(hashMap, i);
        A0T(hashMap);
        A0Q(hashMap);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Map<String, String> A0J(EnumC0621On on) {
        return A0K(on, this.A08.getCurrentPositionInMillis());
    }

    private Map<String, String> A0K(EnumC0621On on, int i) {
        Map<String, String> A0I = A0I(i);
        A0I.put(A0G(0, 6, 122), String.valueOf(on.A00));
        return A0I;
    }

    private void A0M() {
        this.A07.A8P(this.A0A, A0J(EnumC0621On.A04));
    }

    private void A0N() {
        this.A07.A8P(this.A0A, A0J(EnumC0621On.A0A));
    }

    private void A0Q(HashMap<String, String> hashMap) {
        Map<String, String> map = this.A0B;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    private void A0R(Map<String, String> map) {
        AnonymousClass22 A032 = this.A05.A03();
        AnonymousClass21 A002 = A032.A00();
        map.put(A0G(145, 3, 81), String.valueOf(A002.A00()));
        map.put(A0G(148, 3, 95), String.valueOf(A002.A05()));
        map.put(A0G(151, 5, 16), String.valueOf(A002.A02()));
        map.put(A0G(127, 8, 95), String.valueOf(A002.A01() * 1000.0d));
        map.put(A0G(82, 7, 76), String.valueOf(A002.A03() * 1000.0d));
        String str = this.A02;
        if (str != null) {
            map.put(A0G(135, 4, 26), str);
        }
        String str2 = this.A03;
        if (str2 != null) {
            map.put(A0G(139, 6, 90), str2);
        }
        AnonymousClass21 A012 = A032.A01();
        map.put(A0G(110, 3, 127), String.valueOf(A012.A00()));
        map.put(A0G(113, 3, 74), String.valueOf(A012.A05()));
        map.put(A0G(116, 5, 109), String.valueOf(A012.A02()));
        map.put(A0G(22, 8, 93), String.valueOf(A012.A01() * 1000.0d));
        map.put(A0G(75, 7, 78), String.valueOf(A012.A03() * 1000.0d));
    }

    private void A0S(Map<String, String> map) {
        map.put(A0G(30, 9, 11), String.valueOf(this.A08.A7b()));
        map.put(A0G(93, 4, 51), Long.toString(this.A08.getInitialBufferTime()));
    }

    private void A0T(Map<String, String> map) {
        Rect rect = new Rect();
        this.A08.getGlobalVisibleRect(rect);
        map.put(A0G(97, 2, 122), String.valueOf(rect.top));
        map.put(A0G(91, 2, 63), String.valueOf(rect.left));
        map.put(A0G(89, 2, 116), String.valueOf(this.A08.getMeasuredHeight()));
        map.put(A0G(104, 2, 123), String.valueOf(this.A08.getMeasuredWidth()));
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) this.A06.getSystemService(A0G(156, 6, 68))).getDefaultDisplay().getMetrics(metrics);
        map.put(A0G(121, 3, 26), String.valueOf(metrics.heightPixels));
        map.put(A0G(124, 3, 100), String.valueOf(metrics.widthPixels));
    }

    private void A0U(Map<String, String> map, int i) {
        map.put(A0G(99, 5, 109), String.valueOf(((float) this.A00) / 1000.0f));
        map.put(A0G(106, 4, 5), String.valueOf(((float) i) / 1000.0f));
    }

    public final int A0V() {
        return this.A01;
    }

    public final Bundle A0W() {
        A0f(A0V(), A0V());
        Bundle bundle = new Bundle();
        bundle.putInt(A0G(57, 18, 2), this.A01);
        bundle.putInt(A0G(39, 18, 44), this.A00);
        bundle.putBundle(A0G(6, 16, 29), this.A05.A02());
        return bundle;
    }

    public final void A0X() {
        this.A05.A04();
        this.A07.A8P(this.A0A, A0J(EnumC0621On.A05));
    }

    public final void A0Y() {
        this.A07.A8P(this.A0A, A0J(EnumC0621On.A07));
    }

    public final void A0Z() {
        this.A07.A8P(this.A0A, A0J(EnumC0621On.A08));
    }

    public final void A0a() {
        if (((double) A0E()) < 0.05d) {
            if (this.A04) {
                A0M();
                this.A04 = false;
            }
        } else if (!this.A04) {
            A0N();
            if (A0D[0].charAt(27) != 'x') {
                String[] strArr = A0D;
                strArr[0] = "XPLItjVbGIZC9JnvDMj8hFJbnbXNZ6Zm";
                strArr[0] = "XPLItjVbGIZC9JnvDMj8hFJbnbXNZ6Zm";
                this.A04 = true;
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A0b() {
        this.A06.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A09);
    }

    public final void A0c() {
        this.A06.getContentResolver().unregisterContentObserver(this.A09);
    }

    public final void A0d(int i) {
        A0g(i, false, false);
    }

    public final void A0e(int i) {
        A0g(i, true, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0f(int i, int i2) {
        A0g(i, true, false);
        this.A00 = i2;
        this.A01 = i2;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0g(int i, boolean z, boolean z2) {
        int i2;
        if (((double) i) > 0.0d && i >= (i2 = this.A01)) {
            if (i > i2) {
                this.A05.A06((double) (((float) (i - i2)) / 1000.0f), (double) A0E());
                this.A01 = i;
                if (z2 || i - this.A00 >= 5000) {
                    JE je = this.A07;
                    String str = this.A0A;
                    Map<String, String> A0K = A0K(EnumC0621On.A09, i);
                    if (A0D[5].length() != 0) {
                        String[] strArr = A0D;
                        strArr[1] = "IXDsMs8MiMzYVjpFmNZXbOdNx8hS7U1p";
                        strArr[6] = "KaqaEYbZ8TBX2kyM8fVmd1OK78kemUif";
                        je.A8P(str, A0K);
                        this.A00 = this.A01;
                        this.A05.A05();
                        return;
                    }
                    throw new RuntimeException();
                }
            }
            if (z) {
                this.A07.A8P(this.A0A, A0K(EnumC0621On.A09, i));
            }
        }
    }
}
