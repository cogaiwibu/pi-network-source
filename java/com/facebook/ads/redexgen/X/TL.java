package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class TL implements AnonymousClass5X {
    public static byte[] A03;
    public static String[] A04;
    public Set<AbstractC01485a> A00 = new HashSet();
    public final QB A01;
    public final List<AnonymousClass5Z> A02 = new ArrayList();

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 107);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-72, -72, -67, 11, -46, -72, -67, 11, 41, 59, 59, 45, 60, 59};
    }

    public static void A03() {
        A04 = new String[]{"Yyt8Jrp", "FvQHlihhdkZe9tXm7YLHdG4gIBqm", "h7ITXytSbKbsxwMfZDKdUPEvMsTrizAq", "0TuNzKSIMRKA8K3EzRQL94hbriXTa7QT", "ySuQOOQJHVodSpCznPaDLfXVVxuxvbGA", "XYB8XYCfCTfWBGtKG07Wi1HuHmIQx2qC", "71D0xe3tljOi7f3b0iOVOXaXnoSWhNo4", "dwdYeokke3ChTNA3vTF4hdqHGwVronGN"};
    }

    public TL(QN qn) {
        this.A01 = qn.A4N(QC.A0B);
        this.A01.A3I(new TK(this));
        A04();
    }

    /* JADX INFO: Multiple debug info for r0v4 com.facebook.ads.redexgen.X.TM: [D('asset' com.facebook.ads.redexgen.X.5a), D('assetJson' org.json.JSONObject)] */
    @Nullable
    public static Set<AbstractC01485a> A01(JSONObject jSONObject) {
        TM A002;
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray = jSONObject.optJSONArray(A00(8, 6, 93));
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject assetJson = optJSONArray.optJSONObject(i);
            if (assetJson == null || (A002 = TM.A00(assetJson)) == null) {
                return null;
            }
            hashSet.add(A002);
            if (A04[1].length() != 21) {
                String[] strArr = A04;
                strArr[6] = "2zeGpFgTpOohtr7xv9EhLTO87hKhrQIZ";
                strArr[3] = "Z45Lb0RXWpRaUi2IX7mXCACeVe5qt7dU";
            } else {
                throw new RuntimeException();
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public synchronized void A04() {
        if (!this.A01.A7i()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<AbstractC01485a> A012 = A01(this.A01.A5x());
        if (!this.A00.equals(A012) && A012 != null) {
            this.A00 = A012;
            for (AnonymousClass5Z listener : this.A02) {
                listener.A3T();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (AbstractC01485a r5 : this.A00) {
                String.format(Locale.US, A00(0, 8, 45), r5.A7B(), r5.getUrl());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass5X
    public final void A3G(AnonymousClass5Z r2) {
        this.A02.add(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass5X
    public final synchronized Set<AbstractC01485a> A5O() {
        return new HashSet(this.A00);
    }
}
