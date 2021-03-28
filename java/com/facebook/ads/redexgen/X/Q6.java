package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Q6 extends AsyncTask<String, Void, Q7> {
    public static byte[] A05;
    public static String[] A06;
    public static final String A07 = Q6.class.getSimpleName();
    public static final Set<String> A08 = new HashSet();
    public AnonymousClass8H A00;
    public AbstractC0645Pl A01;
    public Q5 A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 90);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{48, 0, 3, 57, 33, 22, 22, 11, 22, 68, 11, 20, 1, 10, 13, 10, 3, 68, 17, 22, 8, 94, 68, 122, 117, 122, 119, 116, 124, 44, 55, 46, 46};
    }

    public static void A05() {
        A06 = new String[]{"iMGBqiSHm2uYyOurEO", "JHkNge3qKUrOixxb", "Efd0ZU7p6XsOViiGEn9FTnCEMV0phXsZ", "Qqux8MYyckh5CceEy", "ksejtLtP", "6qwv67", "yXEFufBpuo", "JuPO8KFa"};
    }

    static {
        A05();
        A04();
        A08.add(A01(0, 1, 73));
        A08.add(A01(29, 4, 24));
    }

    public Q6(AnonymousClass8H r2) {
        this(r2, null, null);
    }

    public Q6(AnonymousClass8H r2, Map<String, String> map) {
        this(r2, map, null);
    }

    public Q6(AnonymousClass8H r3, Map<String, String> map, Map<String, String> map2) {
        Map<String, String> postData;
        this.A00 = r3;
        Map<String, String> extraData = null;
        if (map != null) {
            postData = new HashMap<>(map);
        } else {
            postData = null;
        }
        this.A03 = postData;
        this.A04 = map2 != null ? new HashMap<>(map2) : extraData;
    }

    private final Q7 A00(String... strArr) {
        if (KU.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str)) {
                if (!A08.contains(str)) {
                    String A022 = A02(str);
                    if (this.A03 != null && !this.A03.isEmpty()) {
                        for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                            A022 = A03(A022, entry.getKey(), entry.getValue());
                        }
                    }
                    int i = 1;
                    while (true) {
                        int i2 = i + 1;
                        if (i > 2) {
                            return null;
                        }
                        if (A07(A022)) {
                            return new Q7(this.A01);
                        }
                        i = i2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            if (A06[6].length() != 31) {
                String[] strArr2 = A06;
                strArr2[6] = "dO3qGWbyMuVAZQTwO1X30zVxIjEEo";
                strArr2[6] = "dO3qGWbyMuVAZQTwO1X30zVxIjEEo";
                KU.A00(th, this);
                return null;
            }
            throw new RuntimeException();
        }
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 65), LD.A01(this.A00.A02().A5N()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String A012 = A01(3, 1, 92);
        if (str.contains(A012)) {
            A012 = A01(1, 1, 124);
        }
        return str + A012 + str2 + A01(2, 1, 100) + URLEncoder.encode(str3);
    }

    private final void A06(Q7 q7) {
        if (!KU.A02(this)) {
            try {
                if (this.A02 != null) {
                    this.A02.ABq(q7);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }

    /* JADX INFO: Multiple debug info for r7v0 java.lang.String: [D('params' com.facebook.ads.redexgen.X.Q0), D('ex' java.lang.Exception)] */
    @SuppressLint({"CatchGeneralException"})
    private boolean A07(String str) {
        AbstractC0645Pl pl;
        AbstractC0646Pm A002 = Q4.A00(this.A00);
        try {
            if (this.A04 == null || this.A04.size() == 0) {
                pl = A002.ABc(str, new Q0());
            } else {
                Q0 q0 = new Q0();
                q0.A06(this.A04);
                pl = A002.ABd(str, q0.A09());
            }
            this.A01 = pl;
        } catch (Exception e) {
            String str2 = A07;
            Log.e(str2, A01(4, 19, 62) + str, e);
        }
        AbstractC0645Pl pl2 = this.A01;
        return pl2 != null && pl2.A74() == 200;
    }

    public final void A08(Q5 q5) {
        this.A02 = q5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Q7 doInBackground(String[] strArr) {
        if (KU.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }

    public final void onCancelled() {
        Q5 q5 = this.A02;
        if (q5 != null) {
            q5.ABo();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Q7 q7) {
        if (!KU.A02(this)) {
            try {
                A06(q7);
            } catch (Throwable th) {
                if (A06[3].length() != 17) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
                strArr[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
                KU.A00(th, this);
            }
        }
    }
}
