package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import kotlin.UByte;

/* renamed from: com.facebook.ads.redexgen.X.Ci  reason: case insensitive filesystem */
public final class C0318Ci {
    public static String[] A02;
    public int A00;
    public final IQ A01 = new IQ(8);

    static {
        A01();
    }

    public static void A01() {
        A02 = new String[]{"6bTYjI7xiahg1uqAV8eewLZrNfj9ZPj", "ngeXPKLRRDCcDwFHaGe0eDwdNk9MsKP0", "GKtDxJ6", "TMKYymqQa", "6hy2FBj", "omQP2HfChml3facH7odpRvVYds2Y", "0Yg", "2mziQBXjxxZN6M5afK2REUi5LMQCqiEi"};
    }

    private long A00(CL cl) throws IOException, InterruptedException {
        cl.ABZ(this.A01.A00, 0, 1);
        int i = this.A01.A00[0] & UByte.MAX_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((i & i2) == 0) {
            i2 >>= 1;
            if (A02[6].length() != 30) {
                String[] strArr = A02;
                strArr[1] = "eov1UmgRTS2J9JWiL8HKDN2YxzkNqP4T";
                strArr[1] = "eov1UmgRTS2J9JWiL8HKDN2YxzkNqP4T";
                i3++;
            } else {
                throw new RuntimeException();
            }
        }
        int i4 = i & (i2 ^ -1);
        cl.ABZ(this.A01.A00, 1, i3);
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 << 8;
            if (A02[7].charAt(16) != 'G') {
                String[] strArr2 = A02;
                strArr2[1] = "09Vxb0YRh5GFDnmrENphsjvB8xYQhkFk";
                strArr2[1] = "09Vxb0YRh5GFDnmrENphsjvB8xYQhkFk";
                i4 = i6 + (this.A01.A00[i5 + 1] & UByte.MAX_VALUE);
            } else {
                throw new RuntimeException();
            }
        }
        this.A00 += i3 + 1;
        return (long) i4;
    }

    public final boolean A02(CL cl) throws IOException, InterruptedException {
        long A6T = cl.A6T();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (A6T != -1 && A6T <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = A6T;
        }
        int i = (int) j;
        boolean z = false;
        cl.ABZ(this.A01.A00, 0, 4);
        long A0N = this.A01.A0N();
        this.A00 = 4;
        while (A0N != 440786851) {
            int i2 = this.A00 + 1;
            this.A00 = i2;
            if (i2 == i) {
                return false;
            }
            cl.ABZ(this.A01.A00, 0, 1);
            A0N = ((A0N << 8) & -256) | ((long) (this.A01.A00[0] & UByte.MAX_VALUE));
        }
        long A002 = A00(cl);
        long j2 = (long) this.A00;
        if (A002 == Long.MIN_VALUE) {
            return false;
        }
        if (A6T != -1 && j2 + A002 >= A6T) {
            return false;
        }
        while (true) {
            int i3 = this.A00;
            if (((long) i3) >= j2 + A002) {
                return ((long) i3) == j2 + A002;
            }
            if (A00(cl) == Long.MIN_VALUE) {
                return z;
            }
            long A003 = A00(cl);
            if (A003 < 0 || A003 > 2147483647L) {
                return false;
            }
            if (A003 != 0) {
                int i4 = (int) A003;
                cl.A3M(i4);
                this.A00 += i4;
            }
            z = false;
        }
    }
}
