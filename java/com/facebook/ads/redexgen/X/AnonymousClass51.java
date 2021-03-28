package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.FrameMetricsAggregator;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.51  reason: invalid class name */
public final class AnonymousClass51 implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0P;
    public static String[] A0Q;
    public int A00;
    public int A01 = -1;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public JL A07;
    public KL A08;
    @Nullable
    public M7 A09;
    public AbstractC0563Mg A0A;
    public NS A0B;
    @Nullable
    public OV A0C;
    public String A0D;
    public String A0E;
    @Nullable
    public String A0F;
    public boolean A0G = false;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final AudienceNetworkActivity A0L;
    public final AudienceNetworkActivityApi A0M;
    public final C0820Wh A0N;
    public final List<AbstractC01474z> A0O = new ArrayList();

    static {
        A08();
        A07();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0P, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0P = new byte[]{-37, 7, 40, 37, 56, 42, 55, 80, 67, 68, 78, 71, 2, 86, 81, 2, 75, 80, 72, 71, 84, 2, 88, 75, 71, 89, 54, 91, 82, 71, 2, 72, 84, 81, 79, 2, 75, 80, 86, 71, 80, 86, 2, 81, 84, 2, 85, 67, 88, 71, 70, 43, 80, 85, 86, 67, 80, 69, 71, 53, 86, 67, 86, 71, -24, -11, -26, -24, -22, -5, -16, -3, -16, -5, 0, -10, -1, -4, -8, 1, 7, -25, 2, -2, -8, 1, -44, -32, -34, -97, -41, -46, -44, -42, -45, -32, -32, -36, -97, -46, -43, -28, -97, -46, -43, -29, -42, -31, -32, -29, -27, -38, -33, -40, -97, -73, -70, -65, -70, -60, -71, -48, -78, -75, -48, -61, -74, -63, -64, -61, -59, -70, -65, -72, -48, -73, -67, -64, -56, 1, 13, 11, -52, 4, -1, 1, 3, 0, 13, 13, 9, -52, -1, 2, 17, -52, 7, 12, 18, 3, 16, 17, 18, 7, 18, 7, -1, 10, -52, -1, 1, 18, 7, 20, 7, 18, 23, -3, 2, 3, 17, 18, 16, 13, 23, 3, 2, -32, -20, -22, -85, -29, -34, -32, -30, -33, -20, -20, -24, -85, -34, -31, -16, -85, -26, -21, -15, -30, -17, -16, -15, -26, -15, -26, -34, -23, -85, -31, -26, -16, -22, -26, -16, -16, -30, -31, 15, 27, 25, -38, 18, 13, 15, 17, 14, 27, 27, 23, -38, 13, 16, 31, -38, 21, 26, 32, 17, 30, 31, 32, 21, 32, 21, 13, 24, -38, 16, 21, 31, 28, 24, 13, 37, 17, 16, -23, -11, -13, -76, -20, -25, -23, -21, -24, -11, -11, -15, -76, -25, -22, -7, -76, -17, -12, -6, -21, -8, -7, -6, -17, -6, -17, -25, -14, -76, -21, -8, -8, -11, -8, 16, 28, 26, -37, 19, 14, 16, 18, 15, 28, 28, 24, -37, 14, 17, 32, -37, 22, 27, 33, 18, 31, 32, 33, 22, 33, 22, 14, 25, -37, 19, 22, 27, 22, 32, 21, 12, 14, 16, 33, 22, 35, 22, 33, 38, 54, 66, 64, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 52, 55, 70, 1, 60, 65, 71, 56, 69, 70, 71, 60, 71, 60, 52, 63, 1, 60, 64, 67, 69, 56, 70, 70, 60, 66, 65, 1, 63, 66, 58, 58, 56, 55, 77, 94, 77, 86, 92, 49, 38, 51, 41, 56, 40, 38, 53, 42, 69, 61, 60, 65, 57, 76, 65, 71, 70, 28, 57, 76, 57, 18, 14, 3, 5, 7, 15, 7, 16, 22, -21, 6, -7, -8, -5, -3, -5, -22, -14, -3, 87, 89, 76, 75, 76, 77, 80, 85, 76, 75, 54, 89, 80, 76, 85, 91, 72, 91, 80, 86, 85, 50, 76, 96, 78, 65, 77, 81, 65, 79, 80, 48, 69, 73, 65, -7, -15, -17, -10, -57, -20, -6, -21, -8, -39, -21, -23, -11, -12, -22, -7, 45, 40, 24, 40, 43, 34, 30, 39, 45, 26, 45, 34, 40, 39, -11, -18, -23, -15, -11, -27, -55, -28, 58, 45, 41, 59, 24, 61, 52, 41};
    }

    public static void A08() {
        A0Q = new String[]{"6hyfNvrTK6t0uOk4ZUiKTcly4lO9QIT3", "Cx5XWQG9gTlQcsVl0OO6K9WlulTSTZ", "4fLDdlgMQ2q", "AM05mUF2qaDkDYU3MyDNTK", "rN7iVf06fBiMXo1UDWoI2bEJDxOmVmjv", "9bqAz3M9pAQkcUJXzFdGLS", "1D1uNCEUmAwDpqE", "h0QQnxfLOYpp7kAK6sPhgGYv8wQTA65G"};
    }

    public AnonymousClass51(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0L = audienceNetworkActivity;
        this.A0M = audienceNetworkActivityApi;
        this.A0N = AnonymousClass57.A01(audienceNetworkActivity);
        this.A0N.A0C(this);
    }

    @Nullable
    private M7 A01(Intent intent) {
        C01464y r3 = new C01464y(this, intent, this.A0N.A06(), this.A0N, null);
        if (this.A08 == null) {
            return null;
        }
        switch (C01454x.A00[this.A08.ordinal()]) {
            case 1:
                return C01464y.A0L(r3, this.A06);
            case 2:
                return C01464y.A0F(r3);
            case 3:
                return C01464y.A0G(r3);
            case 4:
                return C01464y.A0H(r3);
            case 5:
                M7 A0I2 = C01464y.A0I(r3);
                if (A0Q[1].length() != 0) {
                    String[] strArr = A0Q;
                    strArr[1] = "wwrXZHO6We2";
                    strArr[1] = "wwrXZHO6We2";
                    return A0I2;
                }
                String[] strArr2 = A0Q;
                strArr2[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                strArr2[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                return A0I2;
            case 6:
                return C01464y.A0J(r3);
            case 7:
                M7 A0K2 = C01464y.A0K(r3);
                if (A0Q[2].length() != 25) {
                    String[] strArr3 = A0Q;
                    strArr3[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                    strArr3[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                    return A0K2;
                }
                throw new RuntimeException();
            case 8:
                return C01464y.A0C(r3);
            case 9:
                M7 A0D2 = C01464y.A0D(r3);
                if (A0Q[7].charAt(27) != 'B') {
                    String[] strArr4 = A0Q;
                    strArr4[1] = Const.X;
                    strArr4[1] = Const.X;
                    return A0D2;
                }
                throw new RuntimeException();
            case 10:
                return C01464y.A0E(r3);
            default:
                return null;
        }
    }

    private void A05() {
        String str = this.A0F;
        if (str != null) {
            this.A0C = OU.A01(this.A0N, str);
            if (this.A0C != null) {
                this.A06.addView(this.A0C, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void A06() {
        if (!this.A0J) {
            if (A0H()) {
                A0E(EnumC0628Ou.A03.A02());
            } else {
                A0E(A04(139, 48, 47));
            }
            this.A0J = true;
        }
    }

    private void A09(Intent intent) {
        if (J8.A0q(this.A0L)) {
            KL kl = this.A08;
            KL kl2 = KL.A02;
            if (A0Q[2].length() != 25) {
                String[] strArr = A0Q;
                strArr[1] = "ROWUzhbvPevH2";
                strArr[1] = "ROWUzhbvPevH2";
                if (kl != kl2 && Build.VERSION.SDK_INT >= 18) {
                    this.A0B = new NS();
                    this.A0B.A0D(intent.getStringExtra(A04(419, 11, 51)));
                    this.A0B.A0C(this.A0L.getPackageName());
                    long longExtra = intent.getLongExtra(A04(462, 11, 109), 0);
                    if (longExtra != 0) {
                        this.A0B.A0A(longExtra);
                    }
                    TextView textView = new TextView(this.A0L);
                    textView.setText(A04(1, 5, 84));
                    textView.setTextColor(-1);
                    C0535Le.A0P(textView, Color.argb(160, 0, 0, 0));
                    textView.setPadding(5, 5, 5, 5);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(12, -1);
                    layoutParams.addRule(11, -1);
                    textView.setLayoutParams(layoutParams);
                    AnonymousClass50 r1 = new AnonymousClass50(this, null);
                    textView.setOnLongClickListener(r1);
                    this.A06.setOnLongClickListener(r1);
                    this.A06.getOverlay().add(this.A0B);
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0A(Intent intent, @Nullable Bundle bundle) {
        String A042 = A04(FrameMetricsAggregator.EVERY_DURATION, 8, 85);
        String A043 = A04(503, 8, 17);
        String A044 = A04(438, 24, 120);
        if (bundle != null) {
            Bundle adnwSavedStateBundle = C0523Kq.A02(bundle, DynamicLoaderImpl.class.getClassLoader());
            this.A01 = adnwSavedStateBundle.getInt(A044, -1);
            this.A0D = adnwSavedStateBundle.getString(A043);
            this.A08 = (KL) adnwSavedStateBundle.getSerializable(A042);
            return;
        }
        this.A01 = intent.getIntExtra(A044, -1);
        this.A0D = intent.getStringExtra(A043);
        this.A08 = (KL) intent.getSerializableExtra(A042);
        this.A02 = intent.getIntExtra(A04(473, 16, 23), 0) * 1000;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r3.equals(r6) != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0E(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass51.A0E(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void A0F(String str, AnonymousClass1Q r9) {
        if (this.A09 != null) {
            if (this.A0A == null) {
                C0820Wh wh = this.A0N;
                this.A0A = C0564Mh.A02(wh, wh.A06(), str, r9, this.A09, new C0725Sq(this, null));
                this.A0A.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            C0535Le.A0M(this.A0A);
            C0535Le.A0X(this.A06);
            this.A06.addView(this.A0A);
            this.A0A.A0J();
        }
    }

    /* access modifiers changed from: private */
    public void A0G(String str, @Nullable AnonymousClass9I r7) {
        Intent intent = new Intent(str + A04(0, 1, 50) + this.A0D);
        if (r7 != null) {
            intent.putExtra(A04(392, 5, 121), r7);
        }
        AnonymousClass2F.A00(this.A0L).A08(intent);
    }

    private boolean A0H() {
        return this.A08 == KL.A0B || this.A08 == KL.A0A;
    }

    public final AudienceNetworkActivity A0I() {
        return this.A0L;
    }

    public final C0820Wh A0J() {
        return this.A0N;
    }

    @VisibleForTesting
    public final void A0K() {
        if (A0H()) {
            A0E(EnumC0628Ou.A09.A02());
        } else {
            A0E(A04(265, 35, 23));
        }
    }

    public final void A0L(AbstractC01474z r2) {
        this.A0O.add(r2);
    }

    public final void A0M(AbstractC01474z r2) {
        this.A0O.remove(r2);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void finish(int i) {
        this.A0N.A0A().A2R(String.valueOf(A0I().hashCode()), i);
        if (!this.A0L.isFinishing()) {
            if (J8.A15(this.A0N) && !this.A0I && !this.A0H) {
                this.A0N.A0A().A8b();
                A0K();
            }
            if (!A0H() || this.A0G) {
                A0E(A04(187, 39, 14));
            } else {
                A0E(EnumC0628Ou.A05.A02());
            }
            A06();
            this.A0M.finish(i);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        this.A03 += currentTimeMillis - this.A04;
        this.A04 = currentTimeMillis;
        if (this.A03 > ((long) this.A02)) {
            boolean shouldIntercept = false;
            for (AbstractC01474z r0 : this.A0O) {
                if (r0.A7U()) {
                    shouldIntercept = true;
                }
            }
            if (!shouldIntercept) {
                this.A0M.onBackPressed();
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onConfigurationChanged(Configuration configuration) {
        M7 m7 = this.A09;
        if (m7 instanceof C0858Xt) {
            C0858Xt xt = (C0858Xt) m7;
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[2] = "hDbrw";
            strArr2[2] = "hDbrw";
            xt.onConfigurationChanged(configuration);
        }
        if (this.A00 != configuration.orientation) {
            HashMap hashMap = new HashMap();
            int i = configuration.orientation;
            String A042 = A04(489, 14, 74);
            if (i == 1) {
                hashMap.put(A042, A04(430, 8, 26));
            } else {
                hashMap.put(A042, A04(397, 9, 86));
            }
            this.A07.A03(JK.A0K, hashMap);
            this.A00 = configuration.orientation;
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onCreate(@Nullable Bundle bundle) {
        C0537Lg.A02();
        this.A05 = C0523Kq.A01(this.A0L.getIntent(), DynamicLoaderImpl.class.getClassLoader());
        C0820Wh A032 = C0523Kq.A03(this.A05);
        if (A032 != null) {
            this.A0N.A0B(A032.A0A());
            C0820Wh wh = this.A0N;
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[6] = "7njofUp2AYjKONZ";
            strArr2[6] = "7njofUp2AYjKONZ";
            wh.A08(A032.A07());
        }
        this.A0N.A0A().A2S(String.valueOf(A0I().hashCode()));
        this.A0L.requestWindowFeature(1);
        this.A0L.getWindow().setFlags(1024, 1024);
        this.A06 = new RelativeLayout(this.A0L);
        C0535Le.A0P(this.A06, 0);
        this.A0L.setContentView(this.A06, new RelativeLayout.LayoutParams(-1, -1));
        A0A(this.A05, bundle);
        this.A09 = A01(this.A05);
        M7 m7 = this.A09;
        if (m7 == null) {
            this.A0N.A04().A82(A04(64, 11, 24), C02248i.A02, new C02258j(A04(6, 58, 115)));
            A0K();
            finish(7);
            return;
        }
        m7.A7r(this.A05, bundle, this);
        A0E(A04(226, 39, 61));
        this.A04 = System.currentTimeMillis();
        this.A0F = this.A05.getStringExtra(A04(406, 13, 105));
        A05();
        A09(this.A05);
        this.A00 = this.A0L.getResources().getConfiguration().orientation;
        String A042 = A04(75, 11, 36);
        if (bundle != null) {
            this.A0E = bundle.getString(A042);
        } else {
            this.A0E = this.A05.getStringExtra(A042);
        }
        this.A07 = new JL(this.A0E, this.A0N.A06());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        if (r3 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a4, code lost:
        if (r3 != null) goto L_0x0067;
     */
    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDestroy() {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass51.onDestroy():void");
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onPause() {
        this.A0N.A0A().A2U(String.valueOf(A0I().hashCode()));
        this.A03 += System.currentTimeMillis() - this.A04;
        M7 m7 = this.A09;
        if (m7 != null) {
            m7.AAO(false);
            if (!this.A0L.isFinishing()) {
                this.A07.A03(JK.A0E, null);
                this.A0K = true;
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onResume() {
        this.A0N.A0A().A2V(String.valueOf(A0I().hashCode()));
        this.A04 = System.currentTimeMillis();
        M7 m7 = this.A09;
        if (m7 != null) {
            m7.AAl(false);
            if (this.A0K) {
                this.A07.A03(JK.A0F, null);
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        M7 m7 = this.A09;
        if (m7 != null) {
            m7.ACg(bundle2);
        }
        bundle2.putInt(A04(438, 24, 120), this.A01);
        bundle2.putString(A04(503, 8, 17), this.A0D);
        bundle2.putString(A04(75, 11, 36), this.A0E);
        bundle2.putSerializable(A04(FrameMetricsAggregator.EVERY_DURATION, 8, 85), this.A08);
        C0523Kq.A09(bundle, bundle2);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStart() {
        this.A0N.A0A().A2W(String.valueOf(A0I().hashCode()));
        int i = this.A01;
        if (i != -1) {
            C0554Lx.A03(this.A0L, i, this.A0N);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStop() {
        this.A0N.A0A().A2X(String.valueOf(A0I().hashCode()));
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C01685v.A03(null, motionEvent);
        return this.A0M.onTouchEvent(motionEvent);
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        A0K();
        finish(5);
    }
}
