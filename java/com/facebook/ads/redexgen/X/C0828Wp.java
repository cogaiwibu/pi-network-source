package com.facebook.ads.redexgen.X;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Wp  reason: case insensitive filesystem */
public final class C0828Wp extends AnonymousClass8S {
    public static byte[] A00;
    public static final AnonymousClass8M A01 = new AnonymousClass8M(1, A00(165, 5, 82), A00(139, 4, 44));
    public static final AnonymousClass8M A02 = new AnonymousClass8M(0, A00(170, 8, 73), A00(143, 16, 58));
    public static final AnonymousClass8M[] A03 = {A02, A01};
    public static final String A04 = (A00(5, 71, 76) + A02.A01 + A00(0, 3, 23) + A00(159, 6, 101) + A00(4, 1, 53) + C0826Wn.A09.A01 + A00(3, 1, 86));
    public static final String A05;
    public static final String A06;
    public static final String A07 = C0828Wp.class.getSimpleName();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 36);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{19, 14, 19, 91, 63, 44, 45, 36, 45, 60, 45, 72, 46, 58, 39, 37, 72, 28, 7, 3, 13, 6, 27, 72, 63, 32, 45, 58, 45, 72, 38, 39, 60, 72, 45, 48, 33, 59, 60, 59, 72, 64, 59, 45, 36, 45, 43, 60, 72, 89, 72, 46, 58, 39, 37, 72, 13, 30, 13, 6, 28, 27, 72, 63, 32, 45, 58, 45, 72, 28, 7, 3, 13, 6, 27, 70, 8, 53, 46, 40, 61, 57, 36, 34, 35, 109, 58, 37, 40, 35, 109, 57, 63, 52, 36, 35, 42, 109, 57, 34, 109, 41, 40, 33, 40, 57, 40, 109, 46, 37, 36, 33, 41, 33, 40, 62, 62, 109, 57, 34, 38, 40, 35, 62, 99, 22, 49, 41, 62, 51, 54, 59, ByteCompanionObject.MAX_VALUE, 43, 48, 52, 58, 49, 113, 92, 77, 80, 92, 74, 91, 70, 74, 62, 78, 76, 87, 83, 95, 76, 71, 62, 85, 91, 71, 36, 55, 36, 47, 53, 50, 2, 25, 29, 19, 24, 25, 2, 6, 8, 3, 50, 4, 9, 80, 75, 79, 65, 74, 87};
    }

    static {
        A04();
        AnonymousClass8M[] r3 = A03;
        String A002 = A00(178, 6, 0);
        A05 = AnonymousClass8S.A02(A002, r3);
        A06 = AnonymousClass8S.A03(A002, A03, A01);
    }

    public C0828Wp(AnonymousClass8O r1) {
        super(r1);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8S
    public final String A07() {
        return A00(178, 6, 0);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8S
    public final AnonymousClass8M[] A0B() {
        return A03;
    }

    public final Cursor A0C() {
        return A06().rawQuery(A05, null);
    }

    public final String A0D(String str) throws IllegalArgumentException, SQLiteException {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = A06().rawQuery(A06, new String[]{str});
                if (rawQuery.moveToNext()) {
                    str2 = rawQuery.getString(A02.A00);
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    rawQuery.close();
                    return str2;
                }
                String uuid = UUID.randomUUID().toString();
                ContentValues contentValues = new ContentValues(2);
                contentValues.put(A02.A01, uuid);
                contentValues.put(A01.A01, str);
                A06().insertOrThrow(A00(178, 6, 0), null, contentValues);
                rawQuery.close();
                return uuid;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException(A00(125, 14, 123));
        }
    }

    public final void A0E() {
        try {
            A06().execSQL(A04);
        } catch (SQLException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A07, A00(76, 49, 105), e);
            }
        }
    }
}
