package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.It  reason: case insensitive filesystem */
public final class Choreographer$FrameCallbackC0477It implements Choreographer.FrameCallback, Handler.Callback {
    public static byte[] A05;
    public static String[] A06;
    public static final Choreographer$FrameCallbackC0477It A07 = new Choreographer$FrameCallbackC0477It();
    public int A00;
    public Choreographer A01;
    public final Handler A02;
    public final HandlerThread A03 = new HandlerThread(A01(0, 26, 7));
    public volatile long A04 = -9223372036854775807L;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 127);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{-55, -18, -11, -8, -21, -11, -19, -8, -25, -10, -18, -21, -8, -43, -3, -12, -21, -8, -64, -50, -25, -12, -22, -14, -21, -8};
    }

    public static void A06() {
        A06 = new String[]{"7pBVLZrqhDDbZ0tYj5xh6PpAno2m", "xkcxMmw20FKB7FJbtkqD12cEqTB7ze2w", "TM2oCNBKKDXNLmDj8LdFTV0zf2KY6EDx", "0Qcgaz5qfDTLbpJoV0yTITWXMh6lxrN5", "RYkflwVTmTjUKlFHuRroVnAWoEc89IJi", "1MiZZB75", "Nr3lQs", "1me56lfIABHV4"};
    }

    static {
        A06();
        A05();
    }

    public Choreographer$FrameCallbackC0477It() {
        this.A03.start();
        this.A02 = new Handler(this.A03.getLooper(), this);
        this.A02.sendEmptyMessage(0);
    }

    public static Choreographer$FrameCallbackC0477It A00() {
        return A07;
    }

    private void A02() {
        this.A00++;
        if (this.A00 == 1) {
            this.A01.postFrameCallback(this);
        }
    }

    private void A03() {
        this.A01 = Choreographer.getInstance();
    }

    private void A04() {
        this.A00--;
        if (this.A00 == 0) {
            this.A01.removeFrameCallback(this);
            this.A04 = -9223372036854775807L;
        }
    }

    public final void A07() {
        this.A02.sendEmptyMessage(1);
    }

    public final void A08() {
        this.A02.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.A04 = j;
        this.A01.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            A03();
            return true;
        } else if (i == 1) {
            A02();
            return true;
        } else if (i == 2) {
            A04();
            return true;
        } else if (A06[4].charAt(23) != 'W') {
            throw new RuntimeException();
        } else {
            String[] strArr = A06;
            strArr[7] = "NYQIx0THDyroo";
            strArr[5] = "Pe1eikc3";
            return false;
        }
    }
}
