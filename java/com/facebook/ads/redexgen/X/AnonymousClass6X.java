package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.6X  reason: invalid class name */
public final class AnonymousClass6X {
    public static byte[] A07;
    public static String[] A08;
    public int A00;
    public final C01725z A01;
    public final TY A02;
    public final TZ A03;
    public final C0735Ta A04;
    public final AnonymousClass6Y A05;
    public final AnonymousClass71 A06;

    static {
        A05();
        A04();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{-31, 4};
    }

    public static void A05() {
        A08 = new String[]{"Nj4TqS4QnuHXli7th2heksSDMg2Z", "RSouwChKZWzGhunCWCHEu7HkA4YX3nJn", "5fVToSkDBkuydhS3BZw", "o644y0JXIVns0cvIXh4fs0HcxxzuSHU9", "L6wIWC4w0dKe6dclyvwc8pXUf7KK", "NV8kH7O4XMciCHnyYHa8lR80N34PEowy", "S6E1x33SpjjOrFFRELF", "CEXaqd5N8FzuUquPi7vxqko1f9a5yOv1"};
    }

    public AnonymousClass6X(Context context, AnonymousClass6Y r3, C01725z r4) {
        this.A03 = new TZ(context, r4);
        this.A04 = new C0735Ta(context, r4);
        this.A02 = new TY(context, r4);
        this.A06 = new AnonymousClass71(context, r4);
        this.A05 = r3;
        this.A01 = r4;
        A06();
    }

    @Nullable
    public static C01806h A00(int i, String str, int i2, int i3) {
        if (i != 10300) {
            if (i == 10920) {
                return A01(str, i2, i3, EnumC01796g.A03);
            }
            if (!(i == 10940 || i == 10941)) {
                switch (i) {
                    case 10943:
                    case 10944:
                    case 10945:
                        break;
                    default:
                        return null;
                }
            }
        }
        return A01(str, i2, i3, EnumC01796g.A04);
    }

    @Nullable
    public static C01806h A01(String str, int i, int i2, EnumC01796g r6) {
        int i3 = AnonymousClass6W.A00[r6.ordinal()];
        if (i3 == 1) {
            return new C01806h(Integer.valueOf(Integer.parseInt(str)), i, i2);
        }
        if (i3 != 2) {
            return null;
        }
        return new C01806h(str, i, i2);
    }

    /* JADX INFO: Multiple debug info for r0v11 int: [D('deprecatedApiLevel' int), D('minApiLevel' int)] */
    @Nullable
    private List<C01806h> A03(int i) throws JSONException {
        ArrayList arrayList = new ArrayList();
        Map<Integer, String> A0i = this.A01.A0i();
        if (A0i == null || A0i.isEmpty() || !A0i.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        JSONObject jSONObject = new JSONObject(A0i.get(Integer.valueOf(i)));
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = jSONObject.getJSONArray(next);
            if (jSONArray != null && jSONArray.length() == 2) {
                arrayList.add(A00(i, next, jSONArray.getInt(0), jSONArray.getInt(1)));
            }
        }
        return arrayList;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    private final void A06() {
        String A022 = A02(1, 1, 69);
        try {
            JSONObject jSONObject = new JSONObject(this.A01.A0h());
            Integer valueOf = jSONObject.has(A022) ? Integer.valueOf(jSONObject.getInt(A022)) : null;
            if (valueOf != null) {
                this.A00 = valueOf.intValue();
                this.A06.A04(this.A00);
                A07(jSONObject.getJSONArray(A02(0, 1, 51)));
            }
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bd, code lost:
        if (r4.containsKey(r8) == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0105, code lost:
        if (r4.containsKey(r8) == false) goto L_0x00bf;
     */
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A07(org.json.JSONArray r11) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass6X.A07(org.json.JSONArray):void");
    }

    private final boolean A08(EnumSet<EnumC01856m> enumSet) {
        return !enumSet.contains(this.A01.A0a()) || !enumSet.contains(EnumC01856m.A05) || !enumSet.contains(EnumC01856m.A06) || enumSet.contains(EnumC01856m.A0A);
    }

    public final int A09() {
        return this.A00;
    }

    public final TY A0A() {
        return this.A02;
    }

    public final TZ A0B() {
        return this.A03;
    }

    public final C0735Ta A0C() {
        return this.A04;
    }

    public final AnonymousClass71 A0D() {
        return this.A06;
    }
}
