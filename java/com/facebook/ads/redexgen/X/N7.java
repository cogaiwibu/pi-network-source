package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;

public class N7 implements View.OnClickListener {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ C0820Wh A00;
    public final /* synthetic */ N9 A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) - 42);
            if (A03[7].length() != 6) {
                String[] strArr = A03;
                strArr[0] = "PWnwmSQeuTDG1VW6irl4bK69meobJxc3";
                strArr[0] = "PWnwmSQeuTDG1VW6irl4bK69meobJxc3";
                copyOfRange[i4] = b;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-43, -42, -29, -23, -24, -82, -42, -32, -43, -30, -33, 8, 21, 11, 25, 22, 16, 11, -43, 16, 21, 27, 12, 21, 27, -43, 8, 10, 27, 16, 22, 21, -43, -3, -16, -20, -2};
    }

    public static void A02() {
        A03 = new String[]{"vt9IBcWTOr7JWOQj52cGIx3Fb8444AVz", "iaODdCdac2HdoVtHZ9a1KA8cNhJnLj6B", "L", "A4NmupT0027YOOHOGvpFNaMrtY8CJ39o", "W8A11ysplhfn90w2DVqRYjP8EH85", "7B8SgIwzRaqe9uXFtFM8FwB70mlJ", "6", "T7zuxnYUsN1JBNG7ZH"};
    }

    public N7(N9 n9, C0820Wh wh) {
        this.A01 = n9;
        this.A00 = wh;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (TextUtils.isEmpty(this.A01.A04)) {
                    return;
                }
                if (!A00(0, 11, 74).equals(this.A01.A04)) {
                    Intent intent = new Intent(A00(11, 26, 125), Uri.parse(this.A01.A04));
                    intent.addFlags(268435456);
                    C0523Kq.A0C(this.A00, intent);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
                String[] strArr = A03;
                if (strArr[5].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[7] = "plh44Um";
                strArr2[7] = "plh44Um";
            }
        }
    }
}
