package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Arrays;

public class J5 implements ServiceConnection {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ J6 A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{4, 22, 35, 39, 26, 20, 22, -47, 20, 32, 31, 31, 22, 20, 37, 22, 21, -23, -5, 8, 12, -1, -7, -5, -74, -6, -1, 9, -7, 5, 4, 4, -5, -7, 10, -5, -6};
    }

    public static void A02() {
        A02 = new String[]{"gCE7yAWhZ11POJo", "8eM0H3liKB3nGBy13JLbaheObXzockOS", "SrGYKC1xYV5SoIQD7ZF53usJTscK0ftd", "oLip1OJDGHIgZvy2QUOX9qyG369fMg", "6uZfg75M38niEnOd8qY5oGvuLo0AhuLi", "uWwQwstOxxQOEnZtY9gGQbDlT6RzLRhG", "9XdBRAedcNLeI9uVxDe6AZ6PBdWknMtH", "4BOwR4x4EiTbHLOE844U0c6wT73UImO8"};
    }

    public J5(J6 j6) {
        this.A00 = j6;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.A00.A08(C02248i.A1X, new C02258j(A00(0, 17, 51)));
        this.A00.A01 = true;
        this.A00.A00 = new Messenger(iBinder);
        Message obtain = Message.obtain((Handler) null, 1);
        obtain.setData(this.A00.A00());
        try {
            this.A00.A00.send(obtain);
        } catch (RemoteException e) {
            this.A00.A07(C02248i.A1W, new C02258j(e));
        }
        this.A00.A03.unbindService(this);
        String[] strArr = A02;
        if (strArr[3].length() != strArr[0].length()) {
            String[] strArr2 = A02;
            strArr2[5] = "6rYpepdvoTPI6QzkC6GFRKhQTPWG03vn";
            strArr2[2] = "LXAj3j5RTtl8LiKDcCRVk7kWTLRj4LCr";
            return;
        }
        throw new RuntimeException();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.A00.A08(C02248i.A1Y, new C02258j(A00(17, 20, 24)));
        try {
            this.A00.A03.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.A00.A00 = null;
        this.A00.A01 = false;
    }
}
