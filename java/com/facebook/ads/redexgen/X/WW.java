package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WW<T> extends AbstractC01966x<List<T>> {
    public static byte[] A02;
    public static String[] A03;
    public final EnumC01956w A00;
    public final List<T> A01;

    static {
        A04();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{113};
    }

    public static void A04() {
        A03 = new String[]{"9itrjnnCMeXzcKw4LDwr3", "0ZUpi3OgdlmKuABHcG8PMsqc4Oj", "fTRPCIaWt84rUUsVk3HDIivZKs", "V5Apl", "JVZfUK34SIuqNwHf2oV3ojB3sFjQruRb", "fsV6jHlkXkNImPX103xxf", "wiQZRNNXqXk8QOUIHtx5EDu7Qpw", "6g7apQMvF8ZkxnUyBbRCBajSKJlIo"};
    }

    public WW(long j, @Nullable C01946v r9, List<T> list, EnumC01956w r11) {
        super(j, r9, list, EnumC01956w.A08);
        this.A01 = list;
        this.A00 = r11;
        if (!A05()) {
            throw new UnsupportedOperationException();
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(T t) {
        int i = C01896q.A00[this.A00.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return t.length();
        }
        if (i == 3) {
            return t.ADC();
        }
        throw new UnsupportedOperationException();
    }

    private boolean A05() {
        int i = C01896q.A00[this.A00.ordinal()];
        if (!(i == 1 || i == 2)) {
            ListSignalValueType<T>[] listSignalValueTypeArr = A03;
            if (listSignalValueTypeArr[3].length() != listSignalValueTypeArr[0].length()) {
                String[] strArr = A03;
                strArr[4] = "pkJoykusnl5HLvmmS2nCUwVdsFz02CDm";
                strArr[4] = "pkJoykusnl5HLvmmS2nCUwVdsFz02CDm";
                if (i != 3) {
                    return false;
                }
            } else {
                throw new RuntimeException<>();
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.facebook.ads.redexgen.X.WW<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r0v7 java.lang.Object: [D('this' com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T>), D('value' T)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        int i = 0;
        if (A08() == null || ((List) A08()).isEmpty()) {
            return 0;
        }
        for (T t : (List) A08()) {
            i += A00(t);
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (T t : this.A01) {
            int i = C01896q.A00[this.A00.ordinal()];
            if (i == 1 || i == 2) {
                jSONArray.put(t);
            } else {
                ListSignalValueType<T>[] listSignalValueTypeArr = A03;
                if (listSignalValueTypeArr[3].length() != listSignalValueTypeArr[0].length()) {
                    String[] strArr = A03;
                    strArr[3] = "TE27R";
                    strArr[0] = "fy5SSQFd7I5OAEL1WcIst";
                    if (i == 3) {
                        jSONArray.put(t.ADV());
                    }
                } else {
                    throw new RuntimeException<>();
                }
            }
        }
        jSONObject.put((String) A01(0, 1, 30), (Object) jSONArray);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final boolean A0B(AbstractC01966x<List<T>> r10) {
        List<T> A08 = r10.A08();
        T newSignal = A08();
        if (newSignal == null || A08 == null) {
            if (newSignal == null && A08 == null) {
                return true;
            }
            return false;
        } else if (((List) r10.A08()).size() != ((List) A08()).size()) {
            return false;
        } else {
            int i = 0;
            while (true) {
                int size = A08.size();
                if (A03[4].charAt(25) != 'F') {
                    throw new RuntimeException<>();
                }
                String[] strArr = A03;
                strArr[3] = "t4r48";
                strArr[0] = "skb916f7am8mTaTTklPg2";
                if (i >= size) {
                    return true;
                }
                T t = A08.get(i);
                Object obj = newSignal.get(i);
                int i2 = C01896q.A00[this.A00.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    if (!A08.get(i).equals(newSignal.get(i))) {
                        return false;
                    }
                } else if (i2 == 3 && !t.A7a(obj)) {
                    return false;
                }
                i++;
            }
        }
    }
}
