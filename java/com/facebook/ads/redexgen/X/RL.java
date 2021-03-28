package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;

public final class RL extends AbstractC00360p {
    public static byte[] A0E;
    public static String[] A0F;
    public View A00;
    @Nullable
    public View A01;
    public EnumC00460z A02 = EnumC00460z.A03;
    public AnonymousClass10 A03 = null;
    public EnumC0486Jc A04;
    @Nullable
    public String A05;
    public List<View> A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final RG A0D;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 15);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{-57, -16, -20, -21, -99, -30, -11, -32, -30, -19, -15, -26, -20, -21, -30, -11, -12, -12, -17, -18, -27, -18, -29, -11, -11, -53, -44, -47, -53, -45, -55, -54, -44, -51, -42, -23, -27, -29, -46, -48, -39, -38, -33, -27, -28, -53, -58, -80, -76, -88, -82, -84, -35, -38, -28, -27, -21, -29, -30, -25, -33, -12, -25, -29, -11, -97, -110, -98, -103, -86, -99, -87, -77, -44, -57, -40, -57, -40, -23, -35, -14, -28, -15, -36, -42, -31, -26, -31, -18, -19, -20, -11, -86, -87, -78, -99, -84, -10, -4, -15, -18, -15, -24, -26, -24, -19, -96, -94, -107, -109, -111, -109, -104, -107, -113, -99, -107, -108, -103, -111, -120, 126, -113, 122, -38, -43, -56, -41, -38, -49, -42, -37, -2, -17, 2, -2, -114, -109, -118, ByteCompanionObject.MAX_VALUE, -44, -62, -43, -47, -36, -43, -46, -43, -42, -34, -43, -103, -116, -120, -102, -114, -127, 125, -113, ByteCompanionObject.MAX_VALUE, -118, -121, -115, -120, -77, -96, 114, 93, -100, 100, 88, -81, 114, 93, -100, -75, -2, -5, -67, -88, -25, -81, -93, -4, -67, -88, -25, 0};
    }

    public static void A06() {
        A0F = new String[]{"AssHqLhhTyxVt8qn53NKh99glOkg76Zu", "x1ztYNG5B8Yh1fFD9IH28HNLftAJV3DA", "znnjTlsCkULP275jnLAB9UeCHu0mwbQ7", "ZnygQwUKP9vcdRc0ZykdXWpZHZyK4mhg", "TpC7jOiqrQiocH3FafzZC3NFqv5kOY4I", "3gx5dg94KuTf2YQxiOsayTUTecU9lJlq", "0JsvRjae8Zudzo37ubyWjxcMew8uJTBn", "UifaSDkpcUGfPYHJ0LY2wgaMbKOuGMMh"};
    }

    public RL(C0820Wh wh, AbstractC00370q r3, C0641Ph ph, RG rg) {
        super(wh, r3, ph);
        this.A0D = rg;
    }

    private String A02(View view) {
        try {
            return A04(view).toString();
        } catch (JSONException unused) {
            return A01(0, 14, 110);
        }
    }

    private String A03(View view) {
        int width = view.getWidth();
        String A012 = A01(0, 0, 124);
        if (width <= 0 || view.getHeight() <= 0) {
            return A012;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, this.A0D.A0E(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception unused) {
            return A012;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0158, code lost:
        if (r5 != false) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0165, code lost:
        if (r5 != false) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x016a, code lost:
        if ((r10 instanceof com.facebook.ads.MediaView) == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x016c, code lost:
        r4 = A01(56, 9, 111);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x017a, code lost:
        if ((r10 instanceof android.view.ViewGroup) == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x017c, code lost:
        r4 = A01(155, 9, 9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject A04(android.view.View r10) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 411
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RL.A04(android.view.View):org.json.JSONObject");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00360p
    public final void A07(Map<String, String> map) {
        if (this.A0D != null) {
            EnumC0486Jc jc = this.A04;
            if (jc != null) {
                map.put(A01(97, 3, 121), String.valueOf(jc.A04()));
            }
            if (this.A07) {
                map.put(A01(83, 3, 95), Boolean.TRUE.toString());
            }
            if (this.A0B) {
                map.put(A01(89, 3, 112), Boolean.TRUE.toString());
            }
            if (this.A08) {
                map.put(A01(92, 5, 45), Boolean.TRUE.toString());
            }
            if (this.A00 != null && this.A0D.A0i()) {
                map.put(A01(151, 4, 20), A02(this.A00));
            }
            if (this.A00 != null && this.A0D.A0j()) {
                map.put(A01(124, 8, 88), A03(this.A00));
            }
            if (this.A0A) {
                map.put(A01(86, 3, 105), Boolean.TRUE.toString());
            }
            EnumC00460z r0 = this.A02;
            if (r0 != null) {
                map.put(A01(106, 14, 33), r0.toString());
            }
            if (this.A09) {
                map.put(A01(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 4, 80), Boolean.TRUE.toString());
            }
            View view = this.A01;
            if (A0F[0].charAt(27) != 'G') {
                String[] strArr = A0F;
                strArr[0] = "P6MGDEoKncCrYirOOQ1jmq4l0Ss52l96";
                strArr[0] = "P6MGDEoKncCrYirOOQ1jmq4l0Ss52l96";
                if (view != null) {
                    map.put(A01(69, 4, 45), String.valueOf((int) (((float) view.getWidth()) / C0535Le.A01)));
                    map.put(A01(65, 4, 34), String.valueOf((int) (((float) this.A01.getHeight()) / C0535Le.A01)));
                }
                AnonymousClass10 r02 = this.A03;
                if (r02 != null) {
                    map.put(A01(73, 5, 87), r02.toString());
                }
                String str = this.A05;
                if (str != null) {
                    map.put(A01(34, 11, 98), str);
                }
                if (this.A0C) {
                    map.put(A01(78, 5, 108), Boolean.TRUE.toString());
                }
                this.A0D.A0b(map);
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A08(@Nullable View view) {
        this.A01 = view;
    }

    public final void A09(View view) {
        this.A00 = view;
    }

    public final void A0A(EnumC00460z r1) {
        this.A02 = r1;
    }

    public final void A0B(AnonymousClass10 r1) {
        this.A03 = r1;
    }

    public final void A0C(EnumC0486Jc jc) {
        this.A04 = jc;
    }

    public final void A0D(@Nullable String str) {
        this.A05 = str;
    }

    public final void A0E(List<View> clickableViews) {
        this.A06 = clickableViews;
    }

    public final void A0F(boolean z) {
        this.A07 = z;
    }

    public final void A0G(boolean z) {
        this.A08 = z;
    }

    public final void A0H(boolean z) {
        this.A09 = z;
    }

    public final void A0I(boolean z) {
        this.A0A = z;
    }

    public final void A0J(boolean z) {
        this.A0B = z;
    }

    public final void A0K(boolean z) {
        this.A0C = z;
    }
}
