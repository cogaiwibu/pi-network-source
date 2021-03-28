package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.EnumSet;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.6x  reason: invalid class name and case insensitive filesystem */
public abstract class AbstractC01966x<T> {
    public static byte[] A04;
    public static String[] A05;
    public static final String A06 = AbstractC01966x.class.getSimpleName();
    public final long A00;
    @Nullable
    public final C01946v A01;
    public final EnumC01956w A02;
    public final T A03;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{105, 126, 114, 40, 124};
    }

    public static void A05() {
        A05 = new String[]{"IPzGtGdAf7dMWjoiAfsJwT8MSbfW", "XMCeZkZyu3cdrivUr2jZRBASAtioBKsk", "M9df3TmYW4NVaJXwV617xCLf0ka0RL", "QgNQyFbsObpuCkNzfa3XkTwr8fWterHM", "OM6XrXF8htknNzzoWXy", "2umg9hNEEJctkPlZR8BXtgIxIwG9FY0j", "MjJVouBCVmg2kVwWDhDqrlmadtoLZ7M", "22y3hOnyLMExHbJepmdK5jKs80KnwphC"};
    }

    public abstract int A07() throws Exception;

    public abstract JSONObject A09(JSONObject jSONObject) throws JSONException;

    public abstract boolean A0B(AbstractC01966x<T> v);

    static {
        A05();
        A04();
    }

    public AbstractC01966x(long j, @Nullable C01946v r3, T signalValue, EnumC01956w r5) {
        this.A00 = j;
        this.A01 = r3;
        this.A03 = signalValue;
        this.A02 = r5;
    }

    private final long A00() {
        return this.A00;
    }

    @Nullable
    private final C01946v A01() {
        return this.A01;
    }

    private final EnumC01956w A02() {
        return this.A02;
    }

    @SuppressLint({"CatchGeneralException"})
    public final int A06() {
        int length = (A01() != null ? A01().A03().getBytes().length : 0) + 8;
        try {
            return A07() + length;
        } catch (Exception e) {
            AnonymousClass6B.A04(e);
            return length;
        }
    }

    public final T A08() {
        return this.A03;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public final JSONObject A0A(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put(A03(4, 1, 2), (double) (((float) this.A00) / 1000.0f));
            } catch (Throwable th) {
                AnonymousClass6B.A04(th);
            }
        }
        if (this.A01 != null && z) {
            jSONObject.put((String) A03(0, 3, 0), (Object) this.A01.A04());
        }
        if (this.A02 == EnumC01956w.A04 || A08() == null) {
            EnumC01956w r5 = this.A02;
            EnumC01956w r4 = EnumC01956w.A04;
            if (A05[7].charAt(6) != 'n') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "j6hvLenmhks7DifvzYp6ZMm4s1P7WZuQ";
            strArr[7] = "j6hvLenmhks7DifvzYp6ZMm4s1P7WZuQ";
            String A032 = A03(3, 1, 71);
            if (r5 == r4) {
                jSONObject.put(A032, this.A03.A09());
            } else if (this.A03 == null) {
                jSONObject.put(A032, new C01936u(EnumC01926t.A07).A09());
            }
            return jSONObject;
        }
        A09(jSONObject);
        return jSONObject;
    }

    public final boolean A0C(@Nullable AbstractC01966x<T> r9, EnumSet<EnumC01856m> enumSet) {
        long j;
        boolean z;
        boolean z2 = false;
        if (r9 == null || A02() != r9.A02()) {
            return false;
        }
        if (A02() == EnumC01956w.A04 && r9.A02() == EnumC01956w.A04) {
            return A0B(r9);
        }
        boolean z3 = false;
        if (enumSet.contains(EnumC01856m.A0E)) {
            z3 = A0B(r9);
        }
        if (enumSet.contains(EnumC01856m.A0C)) {
            if (A01() == null || r9.A01() == null || !A01().A03().equals(r9.A01().A03())) {
                z = false;
            } else {
                z = true;
            }
            z3 &= z;
        }
        if (!enumSet.contains(EnumC01856m.A0D)) {
            return z3;
        }
        if (A02() == EnumC01956w.A0D || A02() == EnumC01956w.A0B) {
            j = C01725z.A08();
        } else {
            j = C01725z.A09();
        }
        if (Math.abs(this.A00 - r9.A00()) < j) {
            z2 = true;
        }
        return z3 & z2;
    }
}
