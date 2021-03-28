package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.EC;
import com.facebook.ads.redexgen.X.I1;
import java.util.Arrays;

public final class InternalFrame extends Id3Frame {
    public static byte[] A03;
    public static String[] A04;
    public static final Parcelable.Creator<InternalFrame> CREATOR = new EC();
    public final String A00;
    public final String A01;
    public final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 47);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{17, 29, 89, 88, 78, 94, 79, 84, 77, 73, 84, 82, 83, 0, 108, 108, 108, 108, 88, 66, 6, 13, 15, 3, 11, 12, 95};
    }

    public static void A02() {
        A04 = new String[]{"lilP4D7d9BEQwLM9jHUfqGkSnEdU58pn", "afpTaQV4nZSZ2pXKiaVB57IApZ4xj5qk", "YRNhV7avC", "1hSLaROLE5s9UJkRnEYVy3hKzt6jPrhV", "10wPMgxL8A4TQ9Hf5dRzrJ387LzBipD1", "PqYfNOJ9aEgtaoP64w7W5IvflQAuK", "TGXFUdlvkhflYTg3tHRPVMdbYrS98xM0", "clX4aM2L2vONCyf4cEJJ0L4DMPtHH1Oh"};
    }

    static {
        A02();
        A01();
    }

    public InternalFrame(Parcel parcel) {
        super(A00(14, 4, 110));
        this.A01 = (String) I1.A01(parcel.readString());
        this.A00 = (String) I1.A01(parcel.readString());
        this.A02 = (String) I1.A01(parcel.readString());
    }

    public InternalFrame(String str, String str2, String str3) {
        super(A00(14, 4, 110));
        this.A01 = str;
        this.A00 = str2;
        this.A02 = str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        if (r3 != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (r3 != false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.metadata.id3.InternalFrame.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int result;
        int result2;
        int i = 17 * 31;
        String str = this.A01;
        int i2 = 0;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        int i3 = (i + result) * 31;
        String str2 = this.A00;
        if (str2 != null) {
            result2 = str2.hashCode();
        } else {
            result2 = 0;
        }
        int i4 = (i3 + result2) * 31;
        String str3 = this.A02;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i4 + i2;
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(18, 9, 77) + this.A01 + A00(0, 14, 18) + this.A00;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A01);
        parcel.writeString(this.A02);
    }
}
