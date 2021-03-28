package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.Arrays;

@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.Iu  reason: case insensitive filesystem */
public final class C0478Iu {
    public static byte[] A0C;
    public static String[] A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public boolean A08;
    public final WindowManager A09;
    public final C0476Is A0A;
    public final Choreographer$FrameCallbackC0477It A0B;

    static {
        A05();
        A04();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{109, 96, 122, 121, 101, 104, 112, 120, 102, 97, 107, 96, 120};
    }

    public static void A05() {
        A0D = new String[]{"i0Plrx2Nq5R", "0KClt8Z9EM", "nQMuIj2OsVJHQqYmqvawjMpASRVzc92c", "WLkeStMKuRlseW4hkxDKryqccASBMssv", "75mbZl2wj9Oc7L4cfBN0ornHxJ7x4bV4", "cDdFi4obBr6Dm4LziWqhdJNE9f6gL2cC", "Y", "1LOEfBfCv2OZoty488nnb7WvOOH1XlhR"};
    }

    public C0478Iu() {
        this(null);
    }

    public C0478Iu(@Nullable Context context) {
        C0476Is is = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.A09 = (WindowManager) context.getSystemService(A02(7, 6, 115));
        } else {
            this.A09 = null;
        }
        if (this.A09 != null) {
            this.A0A = C0466Ig.A02 >= 17 ? A01(context) : is;
            this.A0B = Choreographer$FrameCallbackC0477It.A00();
        } else {
            this.A0A = null;
            this.A0B = null;
        }
        this.A06 = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
    }

    public static long A00(long vsyncCount, long j, long snappedBeforeNs) {
        long snappedTimeNs;
        long snappedTimeNs2 = j + (snappedBeforeNs * ((vsyncCount - j) / snappedBeforeNs));
        if (vsyncCount <= snappedTimeNs2) {
            snappedTimeNs = snappedTimeNs2 - snappedBeforeNs;
        } else {
            snappedTimeNs = snappedTimeNs2;
            snappedTimeNs2 += snappedBeforeNs;
        }
        return snappedTimeNs2 - vsyncCount < vsyncCount - snappedTimeNs ? snappedTimeNs2 : snappedTimeNs;
    }

    @TargetApi(17)
    private C0476Is A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 117));
        if (displayManager == null) {
            return null;
        }
        return new C0476Is(this, displayManager);
    }

    /* access modifiers changed from: private */
    public void A03() {
        Display defaultDisplay = this.A09.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = 1.0E9d / ((double) defaultDisplay.getRefreshRate());
            String[] strArr = A0D;
            if (strArr[1].length() != strArr[6].length()) {
                String[] strArr2 = A0D;
                strArr2[0] = "cQjBVfAMAaWJXkNWf";
                strArr2[0] = "cQjBVfAMAaWJXkNWf";
                this.A06 = (long) refreshRate;
                this.A07 = (this.A06 * 80) / 100;
                return;
            }
            throw new RuntimeException();
        }
    }

    private boolean A07(long j, long j2) {
        return Math.abs((j2 - this.A05) - (j - this.A04)) > 20000000;
    }

    public final long A08(long j, long j2) {
        long j3 = 1000 * j;
        long j4 = j3;
        long adjustedReleaseTimeNs = j2;
        if (this.A08) {
            if (j != this.A02) {
                this.A01++;
                this.A00 = this.A03;
            }
            long j5 = this.A01;
            if (j5 >= 6) {
                long j6 = this.A00 + ((j3 - this.A04) / j5);
                if (A07(j6, j2)) {
                    this.A08 = false;
                } else {
                    adjustedReleaseTimeNs = (this.A05 + j6) - this.A04;
                    j4 = j6;
                }
            } else if (A07(j3, j2)) {
                this.A08 = false;
            }
        }
        if (!this.A08) {
            this.A04 = j3;
            this.A05 = j2;
            this.A01 = 0;
            this.A08 = true;
        }
        this.A02 = j;
        this.A03 = j4;
        Choreographer$FrameCallbackC0477It it = this.A0B;
        if (it == null || this.A06 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long j7 = it.A04;
        if (j7 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        return A00(adjustedReleaseTimeNs, j7, this.A06) - this.A07;
    }

    public final void A09() {
        if (this.A09 != null) {
            C0476Is is = this.A0A;
            if (is != null) {
                is.A01();
            }
            this.A0B.A08();
        }
    }

    public final void A0A() {
        this.A08 = false;
        if (this.A09 != null) {
            this.A0B.A07();
            C0476Is is = this.A0A;
            if (is != null) {
                is.A00();
            }
            A03();
        }
    }
}
