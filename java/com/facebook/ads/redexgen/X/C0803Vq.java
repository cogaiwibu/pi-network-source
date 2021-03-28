package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.os.Build;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Vq  reason: case insensitive filesystem */
public class C0803Vq implements AbstractC01876o {
    public static byte[] A0K;
    public static String[] A0L;
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final String A08 = A00(0, 2, 111);
    public final String A09 = A00(2, 3, 21);
    public final String A0A = A00(8, 2, 66);
    public final String A0B = A00(5, 3, 111);
    public final String A0C = A00(10, 1, 23);
    public final String A0D = A00(11, 1, 108);
    public final String A0E = A00(12, 1, 75);
    public final String A0F = A00(13, 1, 46);
    public final String A0G = A00(14, 3, 81);
    public final String A0H = A00(17, 3, 106);
    public final String A0I;
    public final String A0J;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 122);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0K = new byte[]{82, 77, -4, -16, -13, 86, 82, 77, 41, 46, -1, 86, 55, 28, 65, 48, 57, 90, 73, 86};
    }

    public static void A02() {
        A0L = new String[]{"iPG1t32u874St7saALvPvxyWeud", "UrmxquXQt8SfDHHjv0dMI1nlqdR4ATyp", "1qXrL8O5q0BtdOAQ3yRptFreZlLrEwpP", "MK9C1gjsPA1p5Mh8DRiOt3aRaZeKw74T", "74UXn4Y4KHUBem1ECJoYPrjerGw", "gVPzEamFaNsCYwnWJNQa", "5P5tuwqKsm7DtqkVVW9zJW12Xln", "iYOHX"};
    }

    public C0803Vq(Sensor sensor) {
        int id;
        int i = 0;
        if (Build.VERSION.SDK_INT < 24) {
            id = 0;
        } else {
            id = sensor.getId();
        }
        this.A03 = id;
        this.A04 = Build.VERSION.SDK_INT >= 21 ? sensor.getMaxDelay() : i;
        this.A00 = sensor.getMaximumRange();
        this.A05 = sensor.getMinDelay();
        this.A0I = sensor.getName();
        this.A01 = sensor.getPower();
        this.A02 = sensor.getResolution();
        this.A06 = sensor.getType();
        this.A0J = sensor.getVendor();
        this.A07 = sensor.getVersion();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    public final boolean A7a(Object obj) {
        C0803Vq vq = (C0803Vq) obj;
        if (this.A03 == vq.A03 && this.A04 == vq.A04 && Math.abs(this.A00 - vq.A00) < C01725z.A01() && this.A05 == vq.A05 && AnonymousClass76.A0G(this.A0I, vq.A0I) && Math.abs(this.A01 - vq.A01) < C01725z.A01() && Math.abs(this.A02 - vq.A02) < C01725z.A01() && this.A06 == vq.A06 && AnonymousClass76.A0G(this.A0J, vq.A0J)) {
            int i = this.A07;
            int i2 = vq.A07;
            String[] strArr = A0L;
            if (strArr[5].length() != strArr[0].length()) {
                String[] strArr2 = A0L;
                strArr2[4] = "On2LWhQKLGEDne7oiFngrXws7ig";
                strArr2[6] = "R1w6gEdPq16FSKrzDdwcQQ9VOsn";
                if (i == i2) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    public final int ADC() {
        return A00(0, 2, 111).length() + 4 + A00(2, 3, 21).length() + 4 + A00(8, 2, 66).length() + 4 + A00(5, 3, 111).length() + 4 + A00(10, 1, 23).length() + this.A0I.length() + A00(11, 1, 108).length() + 4 + A00(12, 1, 75).length() + 4 + A00(13, 1, 46).length() + 4 + A00(14, 3, 81).length() + this.A0J.length() + A00(17, 3, 106).length() + 4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    @SuppressLint({"CatchGeneralException"})
    public final JSONObject ADV() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(0, 2, 111), this.A03);
            jSONObject.put(A00(2, 3, 21), this.A04);
            jSONObject.put(A00(8, 2, 66), (double) this.A00);
            jSONObject.put(A00(5, 3, 111), this.A05);
            jSONObject.put(A00(10, 1, 23), this.A0I);
            jSONObject.put(A00(11, 1, 108), (double) this.A01);
            jSONObject.put(A00(12, 1, 75), (double) this.A02);
            jSONObject.put(A00(13, 1, 46), this.A06);
            jSONObject.put(A00(14, 3, 81), this.A0J);
            jSONObject.put(A00(17, 3, 106), this.A07);
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
        return jSONObject;
    }
}
