package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Zx */
public class C0910Zx implements AbstractC0550Lt {
    public static byte[] A03;
    public static String[] A04;
    public AnonymousClass90 A00;
    public AbstractC0646Pm A01;
    public final Executor A02;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{107, 110, 110, 104, 109, 96, 104, 106, 111, 107, 106, 105, 110, 104, 107, 64, 75, 69, 66, 65, 71, 70, 64, 66, 74, 74, 71, 70, 65, 70, 64, 79, 69, 79, 67, 69, 79, 66, 70, 79, 79, 65, 79, 70, 71, 10, 79, 20, 16, 68, 79, 23, 71, 16, 68, 65, 66, 67, 65, 66, 64, 23, 64, 21, 64, 70, 18, 65, 70, 65, 16, 67, 20, 21, 68, 69, 21, 68, 116, 86, 89, 84, 82, 91, 30, 50, 42, 115, 60, 39, 59, 54, 33, 32, 115, 63, 60, 52, 58, 61, 115, 50, 32, 115, 42, 60, 38, 115, 39, 60, 115, 55, 54, 49, 38, 52, 108, 115, 27, 60, 36, 115, 55, 60, 115, 42, 60, 38, 115, 33, 54, 35, 33, 60, 55, 38, 48, 54, 115, 39, 59, 54, 115, 58, 32, 32, 38, 54, 108, 83, 101, 110, 100, 32, 82, 101, 112, 111, 114, 116, 52, 11, 2, 23, 67, 43, 2, 19, 19, 6, 13, 6, 7, 92, 27, 25, 25, 31, 9, 9, 37, 14, 21, 17, 31, 20, 14, 12, 25, 8, 10, 2, 31, 20, 50, 4, 9, 42, 37, 32, 44, 39, 61, 22, 61, 32, 36, 44, 90, 85, 80, 92, 87, 77, 102, 77, 86, 82, 92, 87, 108, 96, 97, 105, 102, 104, 80, 102, 107, 32, 33, 55, 39, 54, 45, 52, 48, 45, 43, 42, 61, 53, 36, 49, 52, 49, 36, 49, 116, 112, 106, 122, 70, 112, 119, ByteCompanionObject.MAX_VALUE, 118, 106, 108, 122, 109, 64, 118, 123, 122, 113, 107, 118, 121, 118, 122, 109};
    }

    public static void A06() {
        A04 = new String[]{"ZQ30B3g1EnWzQxn3crjjGmBLF8czgnrz", "nRJ0geoMgiM0DOpSqitarteTb49iW4bu", "zkGhqanHWGORl0FJV2wFc9MBhnbxSqBt", "Ydk0P72aTQrHa0LOhdAcfW", "R4envBHR3aj", "p22B9bEQtnR9xLSz", "XdKDLLdRQiXAjT4HFpZKaT6yuzMG741E", "BfaY"};
    }

    public C0910Zx(Executor executor, AnonymousClass90 r3, C0820Wh wh) {
        this.A01 = Q4.A01(wh.A00());
        this.A02 = executor;
        this.A00 = r3;
    }

    /* access modifiers changed from: public */
    private Map<String, String> A03(String str) {
        Q0 miscInfo = new Q0();
        Q0 q0 = new Q0();
        Q0 q02 = new Q0();
        miscInfo.put(A01(InputDeviceCompat.SOURCE_KEYBOARD, 15, 96), C01535f.A00().A03());
        miscInfo.put(A01(220, 9, 112), A01(15, 15, 13));
        miscInfo.put(A01(186, 11, 18), A01(0, 15, 38));
        miscInfo.put(A01(174, 12, 5), A01(30, 48, 9));
        miscInfo.put(A01(197, 11, 54), (System.currentTimeMillis() / 1000) + A01(0, 0, 125));
        String A07 = this.A00.A07();
        if (A07 != null) {
            q02.put(A01(JfifUtil.MARKER_RST0, 12, 70), A07);
        }
        if (A04[2].charAt(28) != 'S') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "6c1y5rO2F72616lTK87Vm3xCzjJjlGKf";
        strArr[1] = "6c1y5rO2F72616lTK87Vm3xCzjJjlGKf";
        q0.put(A01(229, 11, 59), str);
        q0.put(A01(248, 9, 102), LD.A01(q02));
        miscInfo.A05(A01(240, 8, 47), LD.A01(q0));
        return miscInfo;
    }

    /* access modifiers changed from: public */
    private void A07(AnonymousClass90 r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0550Lt
    public final void AAv() {
        Activity A002 = C0525Ks.A00();
        if (A002 != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(A002);
            builder.setTitle(A01(160, 14, 28));
            EditText editText = new EditText(A002);
            editText.setSingleLine(false);
            editText.setImeOptions(1073741824);
            editText.setHint(A01(84, 65, 44));
            editText.setMaxLines(2);
            editText.setMinLines(2);
            builder.setView(editText);
            builder.setNegativeButton(A01(78, 6, 72), new DialogInterface$OnClickListenerC0547Lq(this));
            builder.setPositiveButton(A01(149, 11, 127), new DialogInterface$OnClickListenerC0548Lr(this, editText));
            builder.create().show();
        }
    }
}
