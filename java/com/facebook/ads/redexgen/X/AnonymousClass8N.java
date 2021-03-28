package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.8N  reason: invalid class name */
public class AnonymousClass8N<T> extends AsyncTask<Void, Void, T> {
    public static byte[] A04;
    public static String[] A05;
    public AnonymousClass8Q A00;
    public final C0821Wi A01;
    public final AnonymousClass8R<T> A02;
    public final AnonymousClass9L<T> A03;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 116;
            if (A05[7].charAt(12) != 'P') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "VTML";
            strArr[6] = "VTML";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{31, 28, 47, 28, 29, 28, 46, 32};
    }

    public static void A03() {
        A05 = new String[]{"65r9CRdv0GoLRVNVjbjXzJK5P2ycj7FG", "0CWnyuhck9HOQgwCfxzQ09GVkx", "IEC2mc7xTTQi8lqWDODmms9jEFByhoZx", "6exEWFSZK9oTcnxcvUurXohDGqhdlb0H", "22QzghXqrFZ4DBGtDF", "dbvBYMdgslkBJuEWD9uCPJqFmtTt8cU5", "jZC4Ivj", "4jv2LQemXeCXPfpssPDUuPD2TleIiZzb"};
    }

    public AnonymousClass8N(C0821Wi wi, AnonymousClass8R<T> r2, AnonymousClass9L<T> r3) {
        this.A02 = r2;
        this.A03 = r3;
        this.A01 = wi;
    }

    private final T A00(Void... voidArr) {
        if (KU.A02(this)) {
            return null;
        }
        if (A05[6].length() != 11) {
            String[] strArr = A05;
            strArr[2] = "4eGiZ19xQ4OxGjIavdFldPBRBlbWR0DL";
            strArr[2] = "4eGiZ19xQ4OxGjIavdFldPBRBlbWR0DL";
            T t = null;
            try {
                t = this.A02.A04();
                this.A00 = this.A02.A00();
                return t;
            } catch (Exception e) {
                this.A01.A04().A82(A01(0, 8, 71), C02248i.A0k, new C02258j(e));
                this.A00 = AnonymousClass8Q.A09;
                return t;
            } catch (Throwable queryReturn) {
                KU.A00(queryReturn, this);
                return null;
            }
        } else {
            throw new RuntimeException();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
        if (KU.A02(this)) {
            return null;
        }
        try {
            return A00(voidArr);
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(T t) {
        if (!KU.A02(this)) {
            try {
                if (this.A00 == null) {
                    this.A03.A03(t);
                } else {
                    this.A03.A02(this.A00.A03(), this.A00.A04());
                }
            } catch (Throwable result) {
                KU.A00(result, this);
            }
        }
    }
}
