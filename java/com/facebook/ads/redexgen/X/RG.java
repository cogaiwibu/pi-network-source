package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RG implements AbstractC00290i, AbstractC00340n {
    public static byte[] A0a;
    public static String[] A0b;
    public static final String A0c = RG.class.getSimpleName();
    public int A00;
    public int A01;
    public int A02 = -1;
    public int A03;
    public int A04;
    public int A05 = 200;
    public int A06;
    public int A07;
    public long A08;
    public Uri A09;
    public EnumC00280h A0A;
    public AnonymousClass11 A0B;
    public C0820Wh A0C;
    @Nullable
    public JE A0D;
    public JY A0E;
    public JZ A0F;
    public JZ A0G;
    public JZ A0H;
    public C0484Ja A0I;
    public EnumC0488Je A0J;
    public String A0K;
    public String A0L;
    public String A0M;
    public String A0N;
    public String A0O;
    public String A0P;
    public Collection<String> A0Q;
    public HashMap<String, String> A0R = new HashMap<>();
    public List<C1007bZ> A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0a, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 106);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0a = new byte[]{124, 89, 126, 85, 82, 84, 94, 88, 78, 95, 122, ByteCompanionObject.MAX_VALUE, 110, 106, 123, 108, 62, ByteCompanionObject.MAX_VALUE, 114, 108, 123, ByteCompanionObject.MAX_VALUE, 122, 103, 62, 114, 113, ByteCompanionObject.MAX_VALUE, 122, 123, 122, 62, 122, ByteCompanionObject.MAX_VALUE, 106, ByteCompanionObject.MAX_VALUE, 106, 94, 79, 66, 78, 69, 72, 78, 11, 101, 78, 95, 92, 68, 89, 64, 11, 103, 68, 74, 79, 78, 79, 43, 4, 1, 11, 3, 72, 0, 9, 24, 24, 13, 6, 13, 12, 72, 7, 6, 72, 4, 7, 11, 3, 27, 11, 26, 13, 13, 6, 72, 9, 12, 96, 79, 74, 64, 72, 3, 79, 76, 68, 68, 70, 71, 16, 39, 39, 58, 39, 117, 48, 45, 48, 54, 32, 33, 60, 59, 50, 117, 52, 54, 33, 60, 58, 59, 113, 80, 31, 121, 86, 83, 83, 22, 45, 34, 33, 47, 38, 99, 55, 44, 99, 51, 34, 49, 48, 38, 99, 32, 34, 49, 44, 54, 48, 38, 47, 99, 39, 34, 55, 34, 109, 85, 80, 107, 87, 92, 91, 93, 87, 81, 71, 107, 93, 87, 91, 90, 93, 88, 99, 95, 84, 83, 85, 95, 89, 79, 99, 80, 85, 82, 87, 99, 73, 78, 80, 3, 6, 61, 22, 16, 3, 12, 17, 14, 3, 22, 11, 13, 12, 73, 76, 94, 77, 90, 92, 65, 91, 77, 90, 119, 70, 73, 69, 77, 3, 12, 61, 14, 13, 5, 13, 61, 22, 27, 18, 7, 28, 17, 26, 7, 50, 48, 61, 61, 14, 37, 62, 14, 48, 50, 37, 56, 62, 63, 79, 77, 94, 72, 79, 66, 88, 62, 60, 47, 57, 52, 51, 57, 18, 16, 3, 30, 4, 2, 20, 29, 6, 17, 0, 5, 16, 5, 36, 37, 38, 41, 46, 41, 52, 41, 47, 46, 122, 123, 106, 123, 125, 106, 119, 113, 112, 65, 109, 106, 108, 119, 112, 121, 109, 18, 25, 22, 21, 27, 18, 40, 4, 25, 22, 7, 4, 31, 24, 3, 40, 27, 24, 16, 39, 44, 35, 32, 46, 39, 29, 52, 43, 39, 53, 29, 46, 45, 37, 33, 37, 38, 35, 24, 36, 40, 42, 42, 38, 41, 35, 79, 66, 70, 67, 75, 78, 73, 66, 69, 79, 67, 66, 102, 98, 110, 104, 106, 25, 30, 6, 17, 28, 25, 20, 17, 4, 25, 31, 30, 47, 18, 21, 24, 17, 6, 25, 31, 2, 71, 66, 69, 64, 116, 79, 78, 88, 72, 89, 66, 91, 95, 66, 68, 69, 31, 14, 29, 28, 6, 1, 8, 75, 90, 78, 72, 94, 100, 79, 73, 90, 85, 72, 87, 90, 79, 82, 84, 85, 73, 85, 88, 64, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 73, 75, 86, 84, 86, 77, 92, 93, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 0, 23, 3, 7, 23, 1, 6, 45, 27, 22, 110, 115, 124, 109, 110, 117, 114, 105, 54, 43, 36, 53, 54, 45, 42, 49, 26, 38, 42, 40, 53, 55, 32, 54, 54, 26, 52, 48, 36, 41, 44, 49, 60, 4, 25, 22, 7, 4, 31, 24, 3, 40, 27, 24, 16, 40, 19, 18, 27, 22, 14, 40, 4, 18, 20, 24, 25, 19, 112, 108, 96, 106, 98, 111, 92, 96, 108, 109, 119, 102, 123, 119, 5, 6, 25, 24, 5, 25, 4, 19, 18, 41, 2, 4, 23, 24, 5, 26, 23, 2, 31, 25, 24, 39, 32, 53, 38, 11, 38, 53, 32, 61, 58, 51, 34, 36, 51, 37, 56, 37, 61, 52, 42, 55, 42, 50, 59, 72, 78, 88, 89, 98, 79, 88, 77, 82, 79, 73, 98, 72, 79, 81, 121, 102, 107, 106, 96, 80, 110, 122, 123, 96, ByteCompanionObject.MAX_VALUE, 99, 110, 118, 80, 106, 97, 110, 109, 99, 106, 107, 12, 19, 30, 31, 21, 37, 23, 10, 30, 36, 59, 54, 55, 61, 13, 34, 32, 55, 62, 61, 51, 54, 13, 33, 59, 40, 55, 13, 48, 43, 38, 55, 33, 107, 116, 121, 120, 114, 66, 104, 111, 113, 59, 36, 40, 58, 105, 118, 122, 104, 126, 125, 118, 115, 118, 107, 102, 64, 124, 119, 122, 124, 116, 64, 118, 113, 118, 107, 118, 126, 115, 64, 123, 122, 115, 126, 102, 87, 72, 68, 86, 64, 67, 72, 77, 72, 85, 88, 126, 66, 73, 68, 66, 74, 126, 72, 79, 85, 68, 83, 87, 64, 77};
    }

    public static void A06() {
        A0b = new String[]{"OTBhn", "woE0GsYsDC", "jJJsRhZ6eh", "RbmDZKGZyk", "MbYnCV2deeCvNEpfUSPgn7RvJuamywdV", "va4Mi1JJiq4w08mNkhVxy34L1bzftr4W", "QQZqW8pW387BdDH3gcXSwYVoWAeaIxNz", "E72k8"};
    }

    static {
        A06();
        A05();
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        String A012 = A01(675, 4, 39);
        if (map.containsKey(A012)) {
            hashMap.put(A012, map.get(A012));
        }
        String A013 = A01(479, 8, 119);
        if (map.containsKey(A013)) {
            hashMap.put(A013, map.get(A013));
        }
        return hashMap;
    }

    private void A04() {
        if (!this.A0X) {
            JE je = this.A0D;
            if (A0b[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            strArr[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            if (je != null) {
                je.ABf(this.A0N);
            }
            this.A0X = true;
        }
    }

    private void A07(C0820Wh wh, JSONObject jSONObject, JE je, String str, int i, int i2) {
        this.A0W = true;
        this.A0C = wh;
        this.A0D = je;
        this.A02 = i;
        this.A01 = i2;
        A09(jSONObject, str);
    }

    private void A08(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new RF(this, map2, A03(map)), (long) (this.A04 * 1000));
        } catch (Exception unused) {
        }
    }

    private void A09(JSONObject jSONObject, String str) {
        Uri parse;
        if (this.A0T) {
            throw new IllegalStateException(A01(9, 27, 116));
        } else if (jSONObject != null) {
            C0530Kz.A02(this.A0C, A01(36, 23, 65));
            this.A0L = str;
            this.A0M = jSONObject.optString(A01(469, 10, 24));
            this.A00 = jSONObject.optInt(A01(224, 12, 8), 0);
            String A022 = LD.A02(jSONObject, A01(343, 12, 45));
            if (TextUtils.isEmpty(A022)) {
                parse = null;
            } else {
                parse = Uri.parse(A022);
            }
            this.A09 = parse;
            String[] strArr = new String[12];
            strArr[0] = A01(209, 15, 66);
            strArr[1] = A01(591, 5, 52);
            strArr[2] = A01(583, 8, 59);
            strArr[3] = A01(355, 8, 77);
            strArr[4] = A01(236, 4, 20);
            strArr[5] = A01(537, 14, 105);
            String[] strArr2 = A0b;
            if (strArr2[1].length() == strArr2[3].length()) {
                String[] strArr3 = A0b;
                strArr3[0] = "EgjH3";
                strArr3[7] = "aXmwT";
                strArr[6] = A01(393, 16, 65);
                strArr[7] = A01(551, 21, 28);
                strArr[8] = A01(195, 14, 8);
                strArr[9] = A01(449, 20, 83);
                strArr[10] = A01(433, 16, 83);
                strArr[11] = A01(416, 17, 81);
                for (String str2 : strArr) {
                    this.A0R.put(str2, LD.A02(jSONObject, str2));
                    if (A0b[4].charAt(15) == 'f') {
                        String[] strArr4 = A0b;
                        strArr4[5] = "eWhcqXkmKwACVp6tQL5WW3qntxITuvc7";
                        strArr4[5] = "eWhcqXkmKwACVp6tQL5WW3qntxITuvc7";
                    }
                }
                String A012 = A01(240, 14, 59);
                String A023 = LD.A02(jSONObject, A012);
                if (!TextUtils.isEmpty(A023)) {
                    HashMap<String, String> hashMap = this.A0R;
                    if (A0b[6].charAt(13) != 'D') {
                        String[] strArr5 = A0b;
                        strArr5[6] = "fJLCRXTMzJxf7DhTFL7Dp6MTDwlQmm1t";
                        strArr5[6] = "fJLCRXTMzJxf7DhTFL7Dp6MTDwlQmm1t";
                        hashMap.put(A012, A023);
                    } else {
                        String[] strArr6 = A0b;
                        strArr6[2] = "EZfL37EHMq";
                        strArr6[2] = "EZfL37EHMq";
                        hashMap.put(A012, A023);
                    }
                }
                this.A0G = JZ.A00(jSONObject.optJSONObject(A01(363, 4, 70)));
                this.A0H = JZ.A00(jSONObject.optJSONObject(A01(367, 5, 101)));
                this.A0I = C0484Ja.A00(jSONObject.optJSONObject(A01(572, 11, 62)));
                this.A0N = LD.A02(jSONObject, A01(596, 15, 87));
                this.A0Y = jSONObject.optBoolean(A01(328, 15, 40));
                this.A0Z = jSONObject.optBoolean(A01(309, 19, 29));
                this.A04 = jSONObject.optInt(A01(512, 25, 29), 4);
                this.A03 = jSONObject.optInt(A01(487, 25, 47), 0);
                this.A06 = jSONObject.optInt(A01(679, 31, 117), 0);
                this.A07 = jSONObject.optInt(A01(710, 26, 75), 1000);
                JSONObject optJSONObject = jSONObject.optJSONObject(A01(161, 15, 94));
                if (optJSONObject != null) {
                    this.A0F = JZ.A00(optJSONObject);
                }
                this.A0K = LD.A02(jSONObject, A01(176, 19, 86));
                this.A0A = EnumC00280h.A00(jSONObject.optString(A01(372, 21, 26)));
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(jSONObject.optString(A01(292, 17, 116)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.A0Q = C00300j.A01(jSONArray);
                this.A0P = LD.A02(jSONObject, A01(666, 9, 119));
                this.A08 = jSONObject.optLong(A01(642, 24, 56), -1);
                this.A0O = LD.A02(jSONObject, A01(633, 9, 16));
                String A013 = A01(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, 22, 101);
                if (!jSONObject.has(A013)) {
                    this.A0J = EnumC0488Je.A03;
                } else {
                    this.A0J = jSONObject.optBoolean(A013) ? EnumC0488Je.A05 : EnumC0488Je.A04;
                }
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray(A01(268, 8, 27));
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i = 0; i < length; i++) {
                            RG rg = new RG();
                            rg.A07(this.A0C, optJSONArray.getJSONObject(i), this.A0D, this.A0L, i, length);
                            arrayList.add(new C1007bZ(this.A0C, rg, (AnonymousClass91) null, this.A0E));
                        }
                        this.A0S = arrayList;
                    }
                } catch (JSONException e2) {
                    this.A0C.A04().A82(A01(409, 7, 5), C02248i.A1p, new C02258j(e2));
                    Log.e(A0c, A01(131, 30, 41), e2);
                }
                this.A0T = true;
                this.A0U = A0A();
                return;
            }
            throw new RuntimeException();
        }
    }

    private boolean A0A() {
        if (((!this.A0W && !TextUtils.isEmpty(this.A0R.get(A01(209, 15, 66)))) || (!TextUtils.isEmpty(this.A0R.get(A01(591, 5, 52))) && this.A0W)) && (this.A0G != null || this.A0W)) {
            JZ jz = this.A0H;
            if (A0b[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            strArr[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            if (jz != null || A6i() == AdPlacementType.NATIVE_BANNER) {
                return true;
            }
        }
        return false;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01;
    }

    public final int A0D() {
        return this.A02;
    }

    public final int A0E() {
        int i = this.A03;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public final int A0F() {
        return this.A05;
    }

    public final int A0G() {
        return this.A06;
    }

    public final int A0H() {
        return this.A07;
    }

    public final JZ A0I() {
        if (!A0g()) {
            return null;
        }
        return this.A0F;
    }

    public final JZ A0J() {
        if (!A0g()) {
            return null;
        }
        return this.A0H;
    }

    public final JZ A0K() {
        if (!A0g()) {
            return null;
        }
        return this.A0G;
    }

    public final C0484Ja A0L() {
        if (!A0g()) {
            return null;
        }
        A04();
        return this.A0I;
    }

    public final EnumC0488Je A0M() {
        if (!A0g()) {
            return EnumC0488Je.A03;
        }
        return this.A0J;
    }

    public final Long A0N() {
        if (!A0g()) {
            return -1L;
        }
        return Long.valueOf(this.A08);
    }

    public final String A0O() {
        if (!A0g()) {
            return null;
        }
        A04();
        return LP.A01(this.A0R.get(A01(236, 4, 20)));
    }

    public final String A0P() {
        if (!A0g()) {
            return null;
        }
        return this.A0K;
    }

    public final String A0Q() {
        if (A0g()) {
            return A01(0, 9, 87);
        }
        if (A0b[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A0b;
        strArr[4] = "6LnlrboEXfVkWbJfSSNj7sObvXF9GrkL";
        strArr[4] = "6LnlrboEXfVkWbJfSSNj7sObvXF9GrkL";
        return null;
    }

    public final String A0R() {
        return this.A0M;
    }

    public final String A0S() {
        if (!A0g()) {
            return null;
        }
        return this.A0O;
    }

    public final String A0T() {
        if (!A0g()) {
            return null;
        }
        return this.A0P;
    }

    @Nullable
    public final String A0U(String str) {
        if (!A0g()) {
            return null;
        }
        A04();
        return this.A0R.get(str);
    }

    public final List<C1007bZ> A0V() {
        if (!A0g()) {
            return null;
        }
        return this.A0S;
    }

    public final void A0W() {
        Iterator<C1007bZ> it;
        List<C1007bZ> list = this.A0S;
        if (list != null) {
            boolean isEmpty = list.isEmpty();
            if (A0b[6].charAt(13) != 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
            strArr[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
            if (!isEmpty) {
                List<C1007bZ> list2 = this.A0S;
                if (A0b[2].length() != 10) {
                    it = list2.iterator();
                } else {
                    String[] strArr2 = A0b;
                    strArr2[2] = "wGXHpE1nya";
                    strArr2[2] = "wGXHpE1nya";
                    it = list2.iterator();
                }
                while (true) {
                    boolean hasNext = it.hasNext();
                    if (A0b[2].length() != 10) {
                        String[] strArr3 = A0b;
                        strArr3[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                        strArr3[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                        if (!hasNext) {
                            return;
                        }
                    } else {
                        String[] strArr4 = A0b;
                        strArr4[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                        strArr4[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                        if (!hasNext) {
                            return;
                        }
                    }
                    it.next().unregisterView();
                }
            }
        }
    }

    public final void A0X(AnonymousClass11 r1) {
        this.A0B = r1;
    }

    public final void A0Y(C0820Wh wh, AnonymousClass11 r7, JE je, Map<String, Object> map, JY jy) {
        int i;
        this.A0C = wh;
        this.A0B = r7;
        this.A0D = je;
        this.A0E = jy;
        JSONObject jSONObject = (JSONObject) map.get(A01(278, 4, 14));
        AnonymousClass91 r0 = (AnonymousClass91) map.get(A01(282, 10, 42));
        if (r0 != null) {
            i = r0.A06();
        } else {
            i = 200;
        }
        this.A05 = i;
        A09(jSONObject, LD.A02(jSONObject, A01(276, 2, 15)));
        if (C00300j.A04(wh, this, je)) {
            wh.A0A().A41();
            r7.AAJ(this, new C0495Jm(AdErrorType.NO_FILL, A01(124, 7, 85)));
        } else if (r7 != null) {
            r7.AAG(this);
        }
    }

    public final void A0Z(Map<String, String> urlParams) {
        if (A0g()) {
            if (!J8.A18(this.A0C) || !C0536Lf.A04(urlParams)) {
                HashMap hashMap = new HashMap();
                if (urlParams != null) {
                    hashMap.putAll(urlParams);
                }
                C0530Kz.A02(this.A0C, A01(90, 12, 73));
                AnonymousClass11 r0 = this.A0B;
                if (r0 != null) {
                    r0.AAF(this);
                }
                if (this.A0W) {
                    hashMap.put(A01(261, 7, 55), String.valueOf(this.A02));
                    hashMap.put(A01(254, 7, 70), String.valueOf(this.A01));
                }
                AbstractC00260f adAction = C00270g.A00(this.A0C, this.A0D, this.A0L, this.A09, hashMap);
                if (adAction != null) {
                    try {
                        adAction.A0D();
                    } catch (Exception e) {
                        Log.e(A0c, A01(102, 22, 63), e);
                    }
                }
            } else {
                String str = A0c;
                if (A0b[4].charAt(15) != 'f') {
                    throw new RuntimeException();
                }
                String[] strArr = A0b;
                strArr[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
                strArr[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
                Log.e(str, A01(59, 31, 2));
            }
        }
    }

    public final void A0a(Map<String, String> map) {
        JE je = this.A0D;
        if (je != null) {
            je.A7z(this.A0L, map);
        }
    }

    public final void A0b(Map<String, String> map) {
        if (A0g() && !this.A0V) {
            AnonymousClass11 r0 = this.A0B;
            if (r0 != null) {
                r0.AAH(this);
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.A0W) {
                hashMap.put(A01(261, 7, 55), String.valueOf(this.A02));
                hashMap.put(A01(254, 7, 70), String.valueOf(this.A01));
            }
            if (!TextUtils.isEmpty(A5j()) && this.A0D != null) {
                if (!this.A0W) {
                    this.A0C.A0A().A2a();
                }
                this.A0D.A86(A5j(), hashMap);
            }
            if (A0i() || A0j()) {
                A08(map, hashMap);
            }
            this.A0V = true;
        }
    }

    public final void A0c(Map<String, String> map) {
        JE je = this.A0D;
        if (je != null) {
            je.A8L(this.A0L, map);
        }
    }

    public final void A0d(Map<String, String> map) {
        JE je = this.A0D;
        if (je != null) {
            je.A8M(this.A0L, map);
        }
    }

    public final boolean A0e() {
        return true;
    }

    public final boolean A0f() {
        return A0g() && this.A09 != null;
    }

    public final boolean A0g() {
        return this.A0T && this.A0U;
    }

    public final boolean A0h() {
        return this.A0W;
    }

    public final boolean A0i() {
        if (J8.A0u(this.A0C) && A0g()) {
            boolean z = this.A0Y;
            if (A0b[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            strArr[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0j() {
        if (J8.A0u(this.A0C) && A0g()) {
            boolean z = this.A0Z;
            String[] strArr = A0b;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0b;
            strArr2[2] = "qputmJyOXU";
            strArr2[2] = "qputmJyOXU";
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00290i, com.facebook.ads.redexgen.X.AbstractC00340n
    public final String A5j() {
        return this.A0L;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00290i
    public final Collection<String> A61() {
        return this.A0Q;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00290i
    public final EnumC00280h A6Q() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public AdPlacementType A6i() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final void onDestroy() {
    }
}
